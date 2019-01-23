/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function GetCity()
{
    var state_id = document.getElementById("state_id").value;
    var url = "http://localhost:8084/Gtu_Healthmate/GetCity?state=" + state_id;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function ()
    {
        if (this.readyState === 4 && this.status === 200)
        {
            document.getElementById("city_id").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function GetArea()
{
    var city_id = document.getElementById("city_id").value;
    var url = "http://localhost:8084/Gtu_Healthmate/GetArea?city=" + city_id;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function ()
    {
        if (this.readyState === 4 && this.status === 200)
        {
            document.getElementById("area_id").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function GetHospital()
{
    var area_id = document.getElementById("area_id").value;
    var url = "http://localhost:8084/Gtu_Healthmate/GetHospital?area=" + area_id;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function ()
    {
        if (this.readyState === 4 && this.status === 200)
        {
            document.getElementById("hospital_id").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function GetDoctor()
{
    var hospital_id = document.getElementById("hospital_id").value;
    var url = "http://localhost:8084/Gtu_Healthmate/GetDoctor?hospital=" + hospital_id;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function ()
    {
        if (this.readyState === 4 && this.status === 200)
        {
            document.getElementById("doctor_id").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function GetDate()
{
    var d = new Date();
    var date1 = d.getDate();
    var month = d.getMonth();
    month = month + 1;
    var year = d.getFullYear();
    var total = "<option>Select</option>" + "<option>" + date1 + "/" + month + "/" + year + "</option>";
    date1 = date1 + 1;
    total = total + "<option>" + date1 + "/" + month + "/" + year + "</option>";
    date1 = date1 + 1;
    total = total + "<option>" + date1 + "/" + month + "/" + year + "</option>";
    date1 = date1 + 1;
    total = total + "<option>" + date1 + "/" + month + "/" + year + "</option>";
    date1 = date1 + 1;
    total = total + "<option>" + date1 + "/" + month + "/" + year + "</option>";
    date1 = date1 + 1;
    total = total + "<option>" + date1 + "/" + month + "/" + year + "</option>";
    document.getElementById("date_id").innerHTML = total;
}
function GetTime()
{
    var doctor_id = document.getElementById("doctor_id").value;
    var date_id = document.getElementById("date_id").value;
    var url = "http://localhost:8084/Gtu_Healthmate/GetTime?doctorname=" + doctor_id +"&date=" + date_id;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function ()
    {
        if (this.readyState === 4 && this.status === 200)
        {
            document.getElementById("time_id").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}