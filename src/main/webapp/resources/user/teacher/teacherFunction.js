window.onload = function () {
    let assignHomeworkBtn = document.getElementById("assignHomeWork"),
        assignHomeworkData = document.getElementById("assignHomeworkData"),
        studentHomeworkBtn = document.getElementById("studentHomework"),
        studentHomeworkData = document.getElementById("studentHomeworkData"),
        messageBoardBtn = document.getElementById("messageBoard"),
        messageDate = document.getElementById("messageDate"),
        noticeBtn = document.getElementById("notice"),
        noticeDate = document.getElementById("noticeDate"),
        resetPasswordBtn = document.getElementById("resetPasswordBtn"),
        resetPassword = document.getElementById("resetPassword"),
        listColor = document.getElementsByClassName("listColor");
    assignHomeworkBtn.onclick = function () {
        assignHomeworkData.style.display = "block";
        studentHomeworkData.style.display = "none";
        messageDate.style.display = "none";
        noticeDate.style.display = "none";
        resetPassword.style.display = "none";
    }
    studentHomeworkBtn.onclick = function () {
        assignHomeworkData.style.display = "none";
        studentHomeworkData.style.display = "block";
        messageDate.style.display = "none";
        noticeDate.style.display = "none";
        resetPassword.style.display = "none";
    }
    messageBoardBtn.onclick = function () {
        assignHomeworkData.style.display = "none";
        studentHomeworkData.style.display = "none";
        messageDate.style.display = "block";
        noticeDate.style.display = "none";
        resetPassword.style.display = "none";
    }
    noticeBtn.onclick = function () {
        assignHomeworkData.style.display = "none";
        studentHomeworkData.style.display = "none";
        messageDate.style.display = "none";
        noticeDate.style.display = "block";
        resetPassword.style.display = "none";
    }
    resetPasswordBtn.onclick = function () {
        assignHomeworkData.style.display = "none";
        studentHomeworkData.style.display = "none";
        messageDate.style.display = "none";
        noticeDate.style.display = "none";
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