window.onload = function () {
    let homeworkBtn = document.getElementById("homeworkInformation"),
        homeworkData = document.getElementById("homeworkData"),
        messageBtn = document.getElementById("messageBoard"),
        messageData = document.getElementById("messageDate"),
        noticeBtn = document.getElementById("notice"),
        noticeData = document.getElementById("noticeDate"),
        resetPasswordBtn = document.getElementById("resetPasswordBtn"),
        resetPassword = document.getElementById("resetPassword"),
        listColor = document.getElementsByClassName("listColor");
    homeworkBtn.onclick = function () {
        homeworkData.style.display = "block";
        messageData.style.display = "none";
        noticeData.style.display = "none";
        resetPassword.style.display = "none";
    }
    messageBtn.onclick = function () {
        homeworkData.style.display = "none";
        messageData.style.display = "block";
        noticeData.style.display = "none";
        resetPassword.style.display = "none";
    }
    noticeBtn.onclick = function () {
        homeworkData.style.display = "none";
        messageData.style.display = "none";
        noticeData.style.display = "block";
        resetPassword.style.display = "none";
    }
    resetPasswordBtn.onclick = function () {
        homeworkData.style.display = "none";
        messageData.style.display = "none";
        noticeData.style.display = "none";
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