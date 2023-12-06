var ms_id = 0;
var current_user_id = 0;
var hospital_id = 0;
var html = "";

function isLogged() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const resp = JSON.parse(xhr.responseText);
            let ms = false;
            let admin = false;
            for (const x in resp) {
                console.log(x);
                if (x == "ms_id" ){
                    ms = true;
                    ms_id = resp[x];
                    console.log("i am ms!!!!!!!!!!!!!!");
                    continue;
                }
                if (x == "admin_id"){
                    admin = true;
                    continue;
                }
                if (x == "hosp_id"){
                    hospital_id = resp[x];
                    continue;
                }
            }
            if (admin) {
                        console.log("hello i'm the admin!!");
                        $("#ajaxContent").load("admin.html", function () {
                            createAdminPage();
                            createAdminPage2();
                        });
            } else if(ms){
                        $("#ajaxContent").load("ms_homepage.html", function () {});
            }else{
                    $("#ajaxContent").load("logged.html", function () {
                        info = JSON.parse(xhr.responseText);
                        $("#content").append((createDataFromJSON(resp)));
                    });
            }
        }else{
            $("#ajaxContent").load("buttons.html");
        }
    }
    xhr.open('POST', 'Login?'+info);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

function goHome() {
    $("#ajaxContent").load("doc_menu.html");
}

function PersonalInfo() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const resp = JSON.parse(xhr.responseText);
            info = JSON.parse(xhr.responseText);
            $("#ajaxContent").load("logged.html", function () {
                $("#content").append((createDataFromJSON(resp)));
            });
        }
    }
    xhr.open('POST', 'Login?');
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

var dateTime = "";

function createAppoints(date){
    Promise.all([ Appointments(date,"ms") ]).then(function(values) {
        // all AJAX requests are successfully finished
        // "values" is array containing AJAX responses of all requests
        console.log(values[0]);
        values[0] += '</table></div></div>';
        $("#content").append(values[0]);
    }).catch(function(reason) {
        // one of the AJAX calls failed
        console.log(reason);
    });
}

function Appointments(date,type) { //2022
    if(type === "ms"){
        return new Promise(function(resolve, reject) {
            $("#ajaxContent").load("appointment.html");
            var xhr = new XMLHttpRequest();
            xhr.onload = async function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    html = '<div class="row"><div class="col"><table class="table table-success table-striped">';
                    html += '<tr><th>Patient</th><th>AMKA</th><th>Date and Time</th><th>Vaccine Brand</th><th>Dose Number</th><th>Done</th></tr>'
                    const js = xhr.responseText.split("\n");
                    console.log(js);
                    js.pop();
                    var obj_len = Object.keys(js).length;
                    console.log(obj_len);
                    for (let i in js) {
                        var done = false;
                        var patient = false; //is false when the appointment is not selected by patient
                        var cur_patient = 0; //this is the id of the patient that went to an appointment
                        var rand_id = 0;
                        var canceled = 0;
                        var hosp_id = 0;
                        var dose_id = 0;
                        var dateTime = "";

                        const obj = JSON.parse(js[i]);

                        var count = 1;
                        console.log(obj);
                        for (let j in obj) {
                            if (j == "randevouz_id") {
                                if (j == "randevouz_id") {
                                    rand_id = obj[j];
                                }
                                continue;
                            }

                            console.log(j);
                            if (j == "done") {
                                console.log("status:"+obj[j]);
                                // html += '<td id="st'+rand_id+'">' + obj[j] + '</td>';
                                if (obj[j] == "0") {
                                    canceled = 1;
                                } else if (obj[j] == "1") {
                                    done = true;
                                }
                            }
                            if (j == "user_id") {
                                if (obj[j] != '0') {
                                    patient = true;
                                }
                                console.log("user id: " + obj[j]);
                                cur_patient = obj[j];
                            }
                            if (j == "date_time") {
                                dateTime = obj[j];
                            }
                            if (j == "dose_id") {
                                dose_id = obj[j];
                            }
                            if (j == "hosp_id") {
                                hosp_id = obj[j];
                            }
                        }
                        if (hosp_id != hospital_id) {
                            break;
                        }
                        cur_patient = 1;
                        Promise.all([getPatient(cur_patient, dateTime), getDose(dose_id,canceled,rand_id)]).then(function (values) {
                            // all AJAX requests are successfully finished
                            // "values" is array containing AJAX responses of all requests
                            console.log(values);
                            html += values[0];
                            html += values[1];
                            if(obj_len == count){
                                resolve(html);
                            }
                            console.log(html);
                            count++;
                        }).catch(function (reason) {
                            // one of the AJAX calls failed
                            console.log(reason);
                        });
                    }
                }else{
                    reject("error in appointment");
                }
            }
            xhr.open('GET', 'getAppointment?hosp_id=' + hospital_id + '&date=' + date);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            xhr.send();
        });
    }else{
        checkTime();
    }
}

function getDose(dose_id, canceled,rand_id){ // 2022
    return new Promise(function(resolve, reject) {
        var xhr2 = new XMLHttpRequest();
        xhr2.onload = function () {
            if (xhr2.readyState === 4 && xhr2.status === 200) {
                const obj2 = JSON.parse(xhr2.responseText);
                let html = "";
                var brand = "";
                var dose_num = "";
                for (let k in obj2) {
                    if (k == "brand") {
                        brand += obj2[k];
                    }
                    if (k == "dose_num") {
                        dose_num += obj2[k];
                    }
                }
                html += '<td>' + brand + '</td>';
                html += '<td>' + dose_num + '</td>';
                if (canceled) {
                    console.log("rand id:"+rand_id);
                    html += '<td id="done'+rand_id+'"><button onclick="doneAp(' + rand_id + ')" class="btn btn-primary">Done</button></td>';
                } else {
                    html += '<td>vaccination completed</td>';
                }
                html += '</tr>';
                resolve(html);
            }else{
                reject("error at dose");
            }
        }
        xhr2.open('GET', 'getDoseFromId?dose_id=' + dose_id);
        xhr2.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr2.send();
    });
}

function getPatient(us_id, date){ //2022
    return new Promise(function(resolve, reject) {
        var xhr1 = new XMLHttpRequest();
        xhr1.onload = function () {
            if (xhr1.readyState === 4 && xhr1.status === 200) {
                const obj1 = JSON.parse(xhr1.responseText);
                var fullname = "";
                var curr_amka = "";
                let html = "";
                for (let k in obj1) {
                    if (k == "firstname") {
                        fullname += obj1[k] + " ";
                    }
                    if (k == "lastname") {
                        fullname += obj1[k] + " ";
                    }
                    if (k == "amka") {
                        curr_amka = obj1[k];
                    }
                }
                html += '<tr>';
                html += '<td>' + fullname + '</td>';
                html += '<td>' + curr_amka + '</td>';
                html += '<td>' + date + '</td>';
                resolve(html);
                console.log(html);
            }else{
                reject("error at patient");
            }
        }
        xhr1.open('GET', 'getUserFromId?us_id=' + us_id);
        xhr1.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr1.send();
    });
}

var today = new Date();
var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
function newAp() {
    $("#ajaxContent").load("appointmentForm.html", function () {
        document.getElementById('date').setAttribute('min',date);
        document.getElementById('date').setAttribute('value',date);
    });
}

function availability(date, hour,hosp_id) { // 2022
    return new Promise(function(resolve, reject) {
        var xhr1 = new XMLHttpRequest();
        xhr1.onload = function () {
            if (xhr1.readyState === 4 && xhr1.status === 200) {
                if(xhr1.responseText <= 5){
                    resolve("btn-success");
                }else if(xhr1.responseText <= 10){
                    resolve("btn-warning");
                }else if(xhr1.responseText <= 13){
                    resolve("btn-danger");
                }else{
                    resolve("dis");
                }
            }else{
                reject("error in available appointments");
            }
        }
        let data = "hosp_id="+hosp_id+"&date="+date+"&hour="+hour;
        xhr1.open('GET', 'getAvailableRandevouz?' + data);
        xhr1.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr1.send();
    });

}

async function checkTime() { //2022
    var xhr1 = new XMLHttpRequest();
    xhr1.onload = function () {
        if (xhr1.readyState === 4 && xhr1.status === 200) {
            $("#ajaxContent").load("curr_appointment.html", function () {
                const obj1 = JSON.parse(xhr1.responseText);
                let hosp_name = "";
                let brand = "";
                let date_time = "";
                let dose_num = "";
                for (let k in obj1) {
                    console.log(k);
                    if(k == "hospital_name")
                        hosp_name = obj1[k];
                    if(k == "brand")
                        brand = obj1[k];
                    if(k == "date_time")
                        date_time = obj1[k];
                    if(k == "dose_num")
                        dose_num = obj1[k];
                }
                let html = '<div class="row"><div class="col"><table class="table table-success table-striped">';
                html+= '<tr><th>Hospital Name</th><th>Vaccine Brand</th><th>Dose Number</th><th>Date and Time</th></tr>';
                html+= '<tr><th>'+hosp_name+'</th><th>'+brand+'</th><th>'+dose_num+'</th><th>'+date_time+'</th></tr>';
                html += '</tr></table></div></div>';
                $("#content").append(html);

            });
        }else{
            $("#ajaxContent").load("appointmentForm.html", function () {
                kk();
            });
        }
    }
    xhr1.open('GET', 'checkIfCurrAppoint?us_id=' + us_id);
    xhr1.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr1.send();
}

let strings = [[],[],[],[],[]];
function kk(){ //2022
    $("#schedule").empty();
    html = '<div class="row"><div class="col"><table class="table table-success table-striped">';
    let dates = [];
    let dates1 = [];
    dates.push(today.getDate() + '/0' + (today.getMonth() + 1));
    dates1.push(today.getFullYear() + '-0' + (today.getMonth() + 1) + '-' + today.getDate());
    let i = 1, k = 1;
    while (i < 8) {
        if (today.getDate()+i <= 30) {
            let dt = (today.getDate() + i) + '/0' + (today.getMonth() + 1);
            dates.push(dt);
            dates1.push(today.getFullYear() + '-0' + (today.getMonth() + 1) + '-' + (today.getDate() + i));
        } else {
            let dt = '0'+k + '/0' + (today.getMonth() + 2);
            dates1.push(today.getFullYear() + '-0' + (today.getMonth() + 2) + '-0' + k );
            k++;
            dates.push(dt);
        }
        i++;
    }
    html += '<tr><th>' + dates[0] + '</th><th>' + dates[1] + '</th><th>' + dates[2] + '</th><th>' + dates[3] + '</th><th>' + dates[4] + '</th><th>' + dates[5] + '</th><th>' + dates[6] + '</th></tr>';
    let times = ["08", "10", "12", "14", "16"];
    let hosp_id = document.getElementById("hosp").value;
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 7; j++) {
            Promise.all([availability(dates1[j], times[i], hosp_id)]).then(function (values) {
                xk(values[0],i,j,times[i],dates1[j],hosp_id);
                if(j==6 && i==4){
                    for(let k = 0;k<7;k++){
                        if(k == 0){
                            html += '<tr>';
                        }
                        html += strings[0][k];
                        if(k==6){
                            html += '</tr>';
                        }
                    }
                    for(let k = 0;k<7;k++){
                        if(k == 0){
                            html += '<tr>';
                        }
                        html += strings[1][k];
                        if(k==6){
                            html += '</tr>';
                        }
                    }
                    for(let k = 0;k<7;k++){
                        if(k == 0){
                            html += '<tr>';
                        }
                        html += strings[2][k];
                        if(k==6){
                            html += '</tr>';
                        }
                    }
                    for(let k = 0;k<7;k++){
                        if(k == 0){
                            html += '<tr>';
                        }
                        html += strings[3][k];
                        if(k==6){
                            html += '</tr>';
                        }
                    }
                    for(let k = 0;k<7;k++){
                        if(k == 0){
                            html += '<tr>';
                        }
                        html += strings[4][k];
                        if(k==6){
                            html += '</tr></table></div></div>';
                        }
                    }
                    $("#schedule").empty();
                    $("#schedule").append(html);
                }
            });
        }
    }
}

function xk(val,i,j,times,date,hosp_id) {
    let time_range = times+":00-"+(parseInt(times)+2)+":00";
    let time1 = times;
    let time2 = (parseInt(times)+2);
    strings[i][j] = '<th><button type="submit" class="btn '+val+'" onclick="fill_info(\''+time1+'\',\''+ time2 +'\',\''+ hosp_id +'\',\''+ date+'\')">'+time_range+'</button></th>';
}

var appointment_info = "";
function fill_info(time1,time2,hosp_id,date){
    appointment_info = "";
    appointment_info += "us_id="+us_id+"&time1="+time1+"&time2="+time2+"&date="+date+"&hosp_id="+hosp_id;
}

function addAppointment(){
    console.log("i'm in add appointment");
    console.log(appointment_info);
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("successful add of appointment");
            checkTime();
        }
    }
    xhr.open('POST', 'newAppointment?'+appointment_info);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

function showAppointments() {
    var date = document.getElementById('Apdate').value;
    console.log(date);
    createAppoints(date);
}

function downloadCert(date){
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            const obj1 = JSON.parse(xhr.responseText);
            let name = "";
            for(let k in obj1){
                if(k === "firstname"){
                    name += " " + obj1[k];
                }
                if(k === "lastname"){
                    name += " " + obj1[k];
                }
            }
            var doc = new jsPDF();
            doc.fromHTML("<h1>Certificate of Vaccination</h1>" +
                "<h2>To: "+name+"</h2>" + "<h2>From: "+date+"</h2>"+ "<h2>With phizer vaccine</h2>", 15, 15, {
                'width': 170
            });
            doc.save('certification.pdf');
        }
    }
    xhr.open('GET', 'getUserFromId?us_id='+us_id);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

function doneAp(rand_id){ //2022
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("successful done of appointment");
            $("#done"+rand_id).empty();
            document.getElementById("done"+rand_id).innerText = "vaccination completed";
        }
    }
    xhr.open('POST', 'doneAppointment?randevouz_id='+rand_id);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}

function certificate(){ //2022
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const obj1 = JSON.parse(xhr.responseText);
            let issue;
            for(let k in obj1){
                if(k === "issue_date"){
                    issue = obj1[k];
                }
            }
            $("#ajaxContent").load("cert.html", function (){
                let html = '<button type="button" class="btn btn-primary" onclick="downloadCert(\''+issue+'\')">Get your Certificate</button>';
                $("#content").append(html);
            });
        }else{
            $("#ajaxContent").load("cert.html", function (){
                let html = '<p>You have to complete your vaccination to get a certificate.</p>';
                $("#content").append(html);
            });
        }
    }
    xhr.open('GET', 'getCertificate?user_id='+us_id);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send();
}