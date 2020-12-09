window.onload = function(){
    var classBtn = document.getElementById("classInformation");
    var classData = document.getElementById("classData");
    var teacherBtn = document.getElementById("teacherInformation");
    var teacherData = document.getElementById("teacherDate");
    var studentBtn = document.getElementById("studentInformation");
    var studentData = document.getElementById("studentDate");
    var noticeBtn = document.getElementById("notice");
    var noticeData = document.getElementById("noticeDate");
    var messageBtn = document.getElementById("messageBoard");
    var messageData = document.getElementById("messageDate");
    classBtn.onclick = function(){
        classData.style.display = "block";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "none";
    }
    teacherBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "block";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "none";
    }
    studentBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "block";
        noticeData.style.display = "none";
        messageData.style.display = "none";
    }
    noticeBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "block";
        messageData.style.display = "none";
    }
    messageBtn.onclick = function(){
        classData.style.display = "none";
        teacherData.style.display = "none";
        studentData.style.display = "none";
        noticeData.style.display = "none";
        messageData.style.display = "block";
    }
}