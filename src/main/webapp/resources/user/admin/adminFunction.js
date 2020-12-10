window.onload = function () {
    let classBtn = document.getElementById("classInformation"),
        classData = document.getElementById("classData"),
        teacherBtn = document.getElementById("teacherInformation"),
        teacherData = document.getElementById("teacherDate"),
        studentBtn = document.getElementById("studentInformation"),
        studentData = document.getElementById("studentDate"),
        noticeBtn = document.getElementById("notice"),
        noticeData = document.getElementById("noticeDate"),
        messageBtn = document.getElementById("messageBoard"),
        messageData = document.getElementById("messageDate"),
        resetPasswordBtn = document.getElementById("resetPasswordBtn"),
        resetPassword = document.getElementById("resetPassword"),
        listColor = document.getElementsByClassName("listColor");
    classBtn.onclick = function () {
        classData.style.display = "block";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "none";
        resetPassword.style.display = "none";
    }
    teacherBtn.onclick = function () {
        classData.style.display = "none";
        teacherData.style.display = "block";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "none";
        resetPassword.style.display = "none";
    }
    studentBtn.onclick = function () {
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "block";
        noticeData.style.display = "none";
        messageData.style.display = "none";
        resetPassword.style.display = "none";
    }
    noticeBtn.onclick = function () {
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "block";
        messageData.style.display = "none";
        resetPassword.style.display = "none";
    }
    messageBtn.onclick = function () {
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "block";
        resetPassword.style.display = "none";
    }
    resetPasswordBtn.onclick = function () {
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "none";
        resetPassword.style.display = "block";
    }
    for (let j = 0;j < listColor.length;j++){
        for (var i = 0;i < listColor[j].children.length;i++){
            if (i%2==1){
                listColor[j].children[i].children[0].style.backgroundColor = "white"
            }
        }
    }

}