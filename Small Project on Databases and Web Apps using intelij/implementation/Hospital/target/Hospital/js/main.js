var my_obj;

function check_pass(){
    var p1 = document.getElementById("password").value;
    var p2 = document.getElementById("conpass").value;
    console.log(p1);
    if (p1 !== p2){
        document.getElementById("conpasswordHelp").innerText = "Passwords don't match. Please put 2 same passwords";
        document.getElementById("conpasswordHelp").style.color = "red";
    }else{
        document.getElementById("conpasswordHelp").innerText = "Passwords match.";
        document.getElementById("conpasswordHelp").style.color = "green";
    }
    console.log("check pass");
}

function show_pass(){
    var b = document.getElementById("pass-but");
    var txt = document.getElementById("password");
    if(b.innerText === "Show Password"){
        b.innerText = "Hide Password";
        txt.type = "text";
    }else{
        b.innerText = "Show Password";
        txt.type = "password";
    }
}

function show_conpass(){
    var b = document.getElementById("conpass-but");
    var txt = document.getElementById("conpass");
    if(b.innerText === "Show Password"){
        b.innerText = "Hide Password";
        txt.type = "text";
    }else{
        b.innerText = "Show Password";
        txt.type = "password";
    }
}

function checkIfStrong(){
    var txt = document.getElementById("password").value;
    var size = txt.length;
    var nums = 0;
    var help = document.getElementById("pass_power");
    for(let i=0;i<size;i++){
        if(txt[i] >= 0 && txt[i] <= 9){
            nums++;
        }
    }

    if(nums/size >= 0.5){
        help.innerText = "Weak Password";
        help.style.color = "red";
        return;
    }

    var obj={}
    for(let x = 0; x < size; x++) {
        var l = txt.charAt(x)
        obj[l] = (isNaN(obj[l]) ? 1 : obj[l] + 1);
    }

    var keys =0;
    for(let key in obj){
        if(obj[key]/size >=0.5){
            help.innerText = "Weak Password";
            help.style.color = "red";
            return;
        }
        keys++;
    }
    if(keys/size >= 0.8){
        help.innerText = "Strong Password";
        help.style.color = "green";
    }else{
        help.innerText = "Medium Password";
        help.style.color = "blue";
    }
}

function check_AMKA(){
    var birthdate = document.getElementById("birth").value;
    var amka_init = birthdate.split('-').reverse().join().replaceAll(",","").substring(0,4)+birthdate.split('-').reverse().join().replaceAll(",","").substring(6);
    var amka_val = document.getElementById("amka").value.substring(0,6);
    var amka_p = document.getElementById("amka_p");
    if(amka_init != amka_val){
        amka_p.removeAttribute("hidden");
        amka_p.style.color = "red";
    }else{
        amka_p.setAttribute("hidden",true);
    }
}

function check_cond(){
    var checkbox = document.getElementById("terms");
    var check_p = document.getElementById("check_p");
    if(checkbox.getAttribute("checked") === false){
        check_p.removeAttribute("hidden");
        amka_p.style.color = "red";
    }else{
        amka_p.setAttribute("hidden",true);
    }
}

function setPosition(lat, lon){
    var fromProjection = new OpenLayers.Projection("EPSG:4326");   // Transform from WGS 1984
    var toProjection = new OpenLayers.Projection("EPSG:900913"); // to Spherical Mercator Projection
    var position = new OpenLayers.LonLat(lon, lat).transform( fromProjection, toProjection);
    return position;
}

function handler(position, message,map) {
    var popup = new OpenLayers.Popup.FramedCloud("Popup",
        position, null,
        message, null,
        true // <-- true if we want a close (X) button, false otherwise
    );
    map.addPopup(popup);
}

function check_address(){
    const data = null;
    var city = document.getElementById("city").value;
    var address = document.getElementById("address").value;
    var c = document.getElementById("country");
    var country = c.options[c.selectedIndex].innerText;
    var full_address = address+" "+city+" "+country;
    var address_p = document.getElementById("address_p");
    var my_but = document.getElementById("map_btn");
    var my_map = document.getElementById("Map");
    var ln = document.getElementById("lon");
    var lt = document.getElementById("lat");

    const xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
            my_obj = JSON.parse(this.responseText);
            if(typeof(my_obj[0]) == "undefined"){
                console.log("yeayy");
                address_p.removeAttribute("hidden");
                address_p.innerText = "This address is not available!";
                address_p.style.color = "red";
                my_but.setAttribute("hidden",true);
                my_map.setAttribute("hidden",true);
            }else{
                address_p.setAttribute("hidden",true);
                my_but.setAttribute("hidden",true);
                var display_name = my_obj[0].display_name;
                if(display_name.includes("Heraklion") === false){
                    address_p.removeAttribute("hidden");
                    address_p.innerText = "The service is available only in Heraklion at the moment!";
                    address_p.style.color = "red";
                    my_but.setAttribute("hidden",true);
                    my_map.setAttribute("hidden",true);
                }else{
                    address_p.setAttribute("hidden",true);
                    my_map.setAttribute("hidden",true);
                    my_but.removeAttribute("hidden");
                    console.log(my_obj[0]);
                    ln.value = my_obj[0].lon;
                    lt.value = my_obj[0].lat;
                    return my_obj[0];
                }
            }

        }
    });

    xhr.open("GET", "https://forward-reverse-geocoding.p.rapidapi.com/v1/search?q="+full_address+"&accept-language=en&polygon_threshold=0.0");
    xhr.setRequestHeader("x-rapidapi-host", "forward-reverse-geocoding.p.rapidapi.com");
    xhr.setRequestHeader("x-rapidapi-key", "7dbbb88996mshf047b19ea3726fep1ca9aejsn4bc8f5139125");

    xhr.send(data);
}