var info;
var doc;
var us_id;

function createDataFromJSON(data) {
    var html = "<div class='row'><h2 class='w-50'>Your Information</h2><button class=\"btn btn-primary ml-3 w-50\" id=\"change-but\" type=\"button\" onclick=change(";
    html += ")>Edit</button></div>";
    html += "<div class='row' id='info-t'><table id='t-inf' class=\"table table-success table-striped\">";
    for (const x in data) {
        if(x!="user_id" && x!="ms_id" && x!="certified"){
            var category = x;
            var value = data[x];

            html += "<tr><td>" + category + "</td><td>" + value + "</td></tr>";

        }
    }
    html += "</table></div>";

    return html;

}

//doctors code
function createAdminPage2() {
    const xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let html = '<div class="row"><div class="col"><table class="table table-success table-striped">';
            html += '<tr><th>Username</th><th>Firstname</th><th>Lastname</th><th>Birthdate</th><th>Delete</th></tr>'
            const js = xhr.responseText.split("\n");
            js.pop();
            let text = '';
            for(let i in js){
                const obj = JSON.parse(js[i]);
                text += createDoctor(obj,1);
            }
            html += text;
            html += '</table></div></div>';
            console.log(html);
            $("#users").append(html);
        } else if (xhr.status !== 200) {
            console.log("fail");
        }
    };

    xhr.open('GET', 'getUsers?');
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

function Del(id,num){
    const name = id.getAttribute('id');
    const xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            id.setAttribute('hidden','true');
        }
    }
    xhr.open('GET', 'Delete?username='+name+'&num='+num);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

function Cert(id){
    const name = id.getAttribute('id');
    const xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const e= document.getElementById("cert-"+name);
            $("#cert-"+name).empty();
            e.innerText = "Certified";
        }
    }
    xhr.open('GET', 'Certify?username='+name);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

function createAdminPage() {
    const xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let html = '<div class="row"><div class="col"><table class="table table-success table-striped">';
            html += '<tr><th>Username</th><th>Firstname</th><th>Lastname</th><th>Birthdate</th><th>Certified</th><th>Delete</th></tr>'
            const js = xhr.responseText.split("\n");
            js.pop();
            let text = '';
            for(let i in js){
                const obj = JSON.parse(js[i]);
                text += createDoctor(obj,2);
            }
            html += text;
            html += '</table></div></div>';
            console.log(html);
            $("#doctors").append(html);
        } else if (xhr.status !== 200) {
            console.log("fail");
        }
    };

    xhr.open('GET', 'getDoctors?');
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

 function createDoctor(data,num){
    console.log("createDoctor");
    let username = null;
    let firstname = null, lastname = null, birthdate = null, certified = null;
     let html = '';
    for(let i in data) {
        if (i == "username") {
            username = data[i];
        } else if (i == "firstname") {
            firstname = data[i];
        } else if (i == "lastname") {
            lastname = data[i];
        } else if (i == "birthdate") {
            birthdate = data[i];
        } else if (i == "certified") {
            certified = data[i];
        }
    }
    html += '<tr id="'+username+'">';
     for(let i in data) {
         if (i == "username" || i == "firstname" || i == "lastname" || i == "birthdate") {
             if (data[i] === "admin") {
                 return '';
             }
             html += '<td>' + data[i] + '</td>';
         }
     }
     for(let i in data) {
        if(i === "certified"){
            console.log("hello i'm on certified!!");
            if(data[i] === 1){
                html += '<td>Certified</td>';
            }else{
                html += '<td id="cert-'+username+'"><button class="btn btn-primary" onclick="Cert('+username+')" >Certify</button></td>';
            }
        }
    }
    html += '<td><button class="btn btn-primary" onclick="Del('+username+','+num+')">Delete</button></td>';

    html += '</tr>';
    return html;
 }

function checkUsername() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("name_exists").removeAttribute("hidden");
        }else if (xhr.status !== 200) {
            document.getElementById("name_exists").setAttribute("hidden","true");
        }
    }

    var data = "username="+document.getElementById("username").value;
    xhr.open('GET', 'GetUsername?'+data);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
    console.log("hello");
}

function checkEmail() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("email_exists").removeAttribute("hidden");
        }else if (xhr.status !== 200) {
            document.getElementById("email_exists").setAttribute("hidden","true");
        }
    }

    var data = "email="+document.getElementById("email").value;
    xhr.open('GET', 'getEmail?'+data);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
    console.log("hello");
}

function checkAmka(){
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("amka_exists").removeAttribute("hidden");
        }else if (xhr.status !== 200) {
            document.getElementById("amka_exists").setAttribute("hidden","true");
        }
    }

    var data = "amka="+document.getElementById("amka").value;
    xhr.open('GET', 'getAmka?'+data);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
    console.log("hello");
}


function addUser(){ //2022
    var type = document.getElementById("type");
    var value = type.options[type.selectedIndex].text;
    let xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("success!!");
            // const resp = JSON.parse(xhr.responseText);
            $("#ajaxContent").html("<h1>Successful Registration!");
            $("#ajaxContent").load("buttons.html");
            // $("#ajaxContent").append((createTableFromJSON(resp)));
            // console.log(resp);
        }
    }
    let data = $('#loginForm').serialize();
    if(value == "Medical Staff"){
        var work = document.getElementById("hosp");
        var hospital = work.value;
        data += "&hosp=" + hospital;
        xhr.open('GET', 'addMedical?'+data);
        console.log("addMedical");
    }else{
        xhr.open('GET', 'addUser?'+data);
        console.log("addUser");
    }
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();

}

function when_ms(){
    var hosp = document.getElementById("work");
    var type = document.getElementById("type");
    var value = type.options[type.selectedIndex].text;
    console.log(value);
    if (value == "Medical Staff"){
        hosp.removeAttribute("hidden");
    }else{
        hosp.setAttribute("hidden","true");
    }
}

function showRegistrationForm(){
    $("#ajaxContent").load("register.html");
}

function showLoginForm(){
    $("#ajaxContent").load("login.html");
}

function login(){ //2022
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const resp = JSON.parse(xhr.responseText);
            let doc = false;
            for (const x in resp) {
                if (x == "ms_id"){
                    doc = true;
                    ms_id = resp[x];
                    // break;
                }
                if(x == "user_id"){
                    us_id = resp[x];
                    console.log(us_id);
                }
                console.log("response: "+x+"="+resp[x]);
            }
            for (const x in resp) {
                if (x == "username") {
                    const us = resp[x];
                    if(resp[x] === "admin"){
                        $("#ajaxContent").load("admin.html",function (){
                            createAdminPage();
                            createAdminPage2();
                        });
                    }else if(doc){
                            $("#ajaxContent").load("logged.html",function (){
                                info = JSON.parse(xhr.responseText);
                                for (const x in resp) {
                                    if(x == "username"){
                                        document.getElementById("title").innerText = "Welcome "+resp[x];
                                    }
                                }
                                $("#content").append((createDataFromJSON(resp)));
                            });
                    }else{
                        $("#ajaxContent").load("user_logged.html",function (){
                            info = JSON.parse(xhr.responseText);
                            for (const x in resp) {
                                if(x == "username"){
                                    document.getElementById("title").innerText = "Welcome "+resp[x];
                                }
                            }
                            $("#content").append((createDataFromJSON(resp)));
                        });
                    }
                }
            }
        }else if (xhr.status !== 200) {

            document.getElementById("wc").removeAttribute("hidden");
        }
    }
    let data = $('#loginForm1').serialize();
    console.log("data :"+data);
    console.log("MS ID: "+ms_id);
    xhr.open('POST', 'Login?'+data);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
    console.log("login");
}


//first func
$(document).ready(function ()
{
    isLogged();
});

function logout(){
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            $("#ajaxContent").load("buttons.html");
        }
    }
    xhr.open('POST', 'Logout?');
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
    console.log("logout");
}

function change(){
    var data = info;
    $("#t-inf").remove();
    document.getElementById("change-but").innerText = "Save";
    document.getElementById("change-but").removeAttribute("onclick");
    document.getElementById("change-but").setAttribute("onclick","save()");
    var html = "<form id=\"loginForm\">";
    console.log("info: " + info);
    console.log("data: "+ data);
    for (const x in data) {
        console.log(x);
        if(x!= "username" && x!="amka" && x!="user_id" && x!="dms_id"){
            html += "<div class=\"mb-3\">";
            html += "<label for='" + x +"' class=\"form-label\">" + x + "</label>";
            if(x=="email"){
                html += "<input type='email' class='form-control' id='" + x + "' name='" + x + "' value='" + data[x] + "' required onchange='checkEmail();return false;'>"
                html += "<div id='" + x + "Help' className='form-text'>at least 8 characters (only latin letters)</div>";
                html += "<p id=\"email_exists\" hidden>This email already taken!</p>";
            }else if(x == "password"){
                html += "<div class=\"input-group\">\n" +
                    "            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" aria-describedby=\"passwordHelp\"\n value='" + data[x] +
                    "                  ' pattern=\"(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,15}\" required onchange=\"checkIfStrong()\">\n" +
                    "            <button class=\"btn btn-primary\" id=\"pass-but\" type=\"button\" onclick=show_pass()>Show Password</button>\n" +
                    "        </div>\n" +
                    "        <p id=\"pass_power\"></p>\n" +
                    "        <div id=\"passwordHelp1\" class=\"form-text\">8 to 15 characters It should contain at least one character, one\n" +
                    "            number and one symbol (e.g., ‘#’, ‘$’)</div>";
            }else if(x == "firstname"){
                html += "<input type=\"text\" class=\"form-control\" id=\"firstname\" name=\"firstname\" aria-describedby=\"nameHelp\" required pattern=\"[A-Za-z]{3,30}\" value='" + data[x] + "'>" +
                    "        <div id=\"nameHelp\" class=\"form-text\">3-30 characters</div>";
            }else if(x == "lastname"){
                html += "<input type=\"text\" class=\"form-control\" id=\"lastname\" name=\"lastname\" aria-describedby=\"surnameHelp\" required pattern=\"[A-Za-z]{3,30}\" value='" + data[x] + "'>\n" +
                    "        <div id=\"surnameHelp\" class=\"form-text\">3-30 characters</div>";
            }else if(x == "birthdate") {
                html += "<input type=\"date\" id=\"birthdate\" name=\"birthdate\"\n" +
                    "               value='"+ data[x] + "' " +
                    "               min=\"1920-01-01\" max=\"2005-12-31\" required >";
            }else if(x == "postal_code"){
                html += "<input type=\"text\" class=\"form-control\" id=\"postal_code\" name=\"postal_code\" required pattern=\"[0-9]{5}\" value='" + data[x] + "'>\n";
            }else if(x == "address"){
                html += "<input type=\"text\" class=\"form-control\" id=\"address\" name=\"address\" aria-describedby=\"addressHelp\" required pattern=\"[A-Za-z 0-9]{5,50}\" onchange=\"check_address()\" value='" + data[x] + "'>\n" +
                    "        <div id=\"addressHelp\" class=\"form-text\">5-50 characters</div>\n" +
                    "        <p hidden id=\"address_p\">This address is not available!</p>\n" +
                    "        <button class=\"btn btn-primary mt-3 mb-3\" id=\"auto_comp\" onclick=\"complete()\">Auto-Complete Address</button>\n" +
                    "        <button class=\"btn btn-primary\" id=\"map_btn\" onclick=\"create_map()\" hidden>See Address in Map</button>\n" +
                    "        <div id=\"Map\" style=\"height:200px; width:300px\" hidden></div>";
            }else if(x == "telephone"){
                html += "<input type=\"text\" class=\"form-control\" id=\"telephone\" name=\"telephone\" required pattern=\"[0-9]{1,14}\" value='" + data[x] + "'>";
            }
            html += "</div>";
        }else if(x!= "user_id" && x!="ms_id"){
            html += "<div class=\"mb-3\">";
            html += "<label for='" + x +"' class=\"form-label\">" + x + "</label>";
            html += "<input type=\"text\" class=\"form-control\" id='"+x+"' name='"+x+"' value='"+data[x]+"' disabled>";
            html += "</div>";
        }
    }
    html += "</form>";
    $("#info-t").append(html);
}
