function ValidatePass()
{
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmpass").value;
    if (password !== confirmPassword) {
        error_notifier("Password does not match");
        return false;
    }
    return true;
}

function CheckNotification()
{
    var msg = document.getElementById("msg").value;
    if (msg === "fail")
    {
        error_notifier("The Emailid or Password is Incorrect -_-    Please Try Again");
    } else if (msg === "success")
    {
        success_notifier("You have successfully signed in");
    } else if (msg === "success_profile")
    {
        success_notifier("Your profile successfully updated");
    } else if (msg === "fail_profile")
    {
        error_notifier("Something went wrong! Please try again");
    } else if (msg === "success_password")
    {
        success_notifier("Your password successfully updated");
    } else if (msg === "fail_password")
    {
        error_notifier("Your old password did not match.");
    } else if (msg === "success_forgot")
    {
        success_notifier("Your password Successfully sent to your Email-Id");
    } else if (msg === "fail_forgot")
    {
        error_notifier("Please enter correct Email-id");
    } else if (msg === "success_register")
    {
        success_notifier("Thank you for registering with HealthMate.");
    } else if (msg === "fail_register")
    {
        error_notifier("This Email-ID already exists.");
    } else if (msg === "success_book_appointment")
    {
        success_notifier("You have successfully booked appointment.");
    } else if (msg === "fail_book_appointment")
    {
        error_notifier("Something went wrong! Please Try Again");
    } else if (msg === "error_book_appointment")
    {
        error_notifier("You already booked appointment!");
    }  else if (msg === "admin_activate")
    {
        success_notifier("Profile Successfully Activated.");
    } else if (msg === "admin_deactivate")
    {
        success_notifier("Profile Successfully Deactivated.");
    } else if (msg === "admin_fail")
    {
        error_notifier("Something went wrong! Please try again.");
    }

}

function GetHospitalData()
{
    var url = "http://localhost:8084/Gtu_Healthmate/GetHospitalData";
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function ()
    {
        if (this.readyState === 4 && this.status === 200)
        {
            var response = this.responseText;
            var array = response.split(",");
            document.getElementById("hospitalname").value = array[0];
            document.getElementById("hospitaladdress").value = array[1];
            document.getElementById("hospitalarea").value = array[2];
            document.getElementById("hospitalcity").value = array[3];
            document.getElementById("hospitalstate").value = array[4];
            document.getElementById("hospitalpincode").value = array[5];
            document.getElementById("mobile1").value = array[6];
            document.getElementById("mobile2").value = array[7];
            document.getElementById("country").value = array[8];
            document.getElementById("emailid").value = array[9];
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
    return false;
}

function GetProfileData()
{
    var url = "http://localhost:8084/Gtu_Healthmate/GetProfileData";
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function ()
    {
        if (this.readyState === 4 && this.status === 200)
        {
            var response = this.responseText;
            var array = response.split(",");
            document.getElementById("fname").value = array[0];
            document.getElementById("mname").value = array[1];
            document.getElementById("lname").value = array[2];
            document.getElementById("mobile").value = array[3];
            document.getElementById("emailid").value = array[4];
            document.getElementById("address").value = array[5];
            document.getElementById("city").value = array[6];
            document.getElementById("state").value = array[7];
            document.getElementById("country").value = array[8];
            document.getElementById("pincode").value = array[9];
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
    return false;
}

function error_notifier(msg) {
    notif({
        msg: msg,
        type: "error",
        position: "center"
    });
}
function success_notifier(msg) {
    notif({
        msg: msg,
        type: "success",
        position: "center"
    });
}