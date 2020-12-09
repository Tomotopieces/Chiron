window.onload = function(){
    let classBtn = document.getElementById("classInformation");
    let classData = document.getElementById("classData");
    let teacherBtn = document.getElementById("teacherInformation");
    let teacherData = document.getElementById("teacherDate");
    let studentBtn = document.getElementById("studentInformation");
    let studentData = document.getElementById("studentDate");
    let noticeBtn = document.getElementById("notice");
    let noticeData = document.getElementById("noticeDate");
    let messageBtn = document.getElementById("messageBoard");
    let messageData = document.getElementById("messageDate");
    let resetPasswordBtn = document.getElementById("resetPasswordBtn");
    let resetPassword = document.getElementById("resetPassword");
    classBtn.onclick = function(){
        classData.style.display = "block";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "none";
        resetPassword.style.display = "none";
    }
    teacherBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "block";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "none";
        resetPassword.style.display = "none";
    }
    studentBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "block";
        noticeData.style.display = "none";
        messageData.style.display = "none";
        resetPassword.style.display = "none";
    }
    noticeBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "block";
        messageData.style.display = "none";
        resetPassword.style.display = "none";
    }
    messageBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "block";
        resetPassword.style.display = "none";
    }
    resetPasswordBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "none";
        resetPassword.style.display = "block";
    }
}