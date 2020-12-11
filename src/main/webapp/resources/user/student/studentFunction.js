let messageDate = [
    {
        title: "第一个标题",
        text: "第一个内容",
        time: "第一个时间"
    },
    {
        title: "第二个标题",
        text: "第二个内容",
        time: "第二个时间"
    },
    {
        title: "第三个标题",
        text: "第三个内容",
        time: "第三个时间"
    }
]
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
    for(let i = 0;i<messageDate.length;i++){
        let li1 = document.createElement('li');
        li1.innerHTML = '<div class="row"><div class="col-md-2">'+messageDate[i].title+'</div><div class="col-md-8">'+messageDate[i].text+'</div><div class="col-md-2">'+messageDate[i].time+'</div></div>'
        document.getElementById("messageDateList").appendChild(li1);

    }
    for (let j = 0;j < listColor.length;j++){
        for (let i = 0;i < listColor[j].children.length;i++){
            if (i%2==1){
                listColor[j].children[i].children[0].style.backgroundColor = "white"
            }
        }
    }
    // 鼠标移入出现弹窗
    // homeworkBtn.onmouseover = function () {
    //     console.log("11")
    // }
    // for (let i = 0;i < 3;i++){
    //     btn[i].onclick = function () {
    //         for (let j = 0;j < 3;j++){
    //             if (j==i){
    //                 data[j].style.display = "block";
    //             }else{
    //                 data[j].style.display = "none";
    //             }
    //         }
    //     }
    // }

}