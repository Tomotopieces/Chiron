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
    },
    {
        title: "第四个标题",
        text: "第四个内容",
        time: "第四个时间"
    },
    {
        title: "第五个标题",
        text: "第五个内容",
        time: "第五个时间"
    },
    {
        title: "第六个标题",
        text: "第六个内容",
        time: "第六个时间"
    },
    {
        title: "第七个标题",
        text: "第七个内容",
        time: "第七个时间"
    },
    {
        title: "第九个标题",
        text: "第九个内容",
        time: "第九个时间"
    },
    {
        title: "第十个标题",
        text: "第十个内容",
        time: "第十个时间"
    },
    {
        title: "第十一个标题",
        text: "第十一个内容",
        time: "第十一个时间"
    },
    {
        title: "第十一个标题",
        text: "第十一个内容",
        time: "第十一个时间"
    },
    {
        title: "第十一个标题",
        text: "第十一个内容",
        time: "第十一个时间"
    },
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

    // 页面切换
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

    // 作业数据填入列表
    for(let i = 0;i < 6;i++){
        let homeworkDateLi = document.createElement('li');
        homeworkDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageDate[i].title + '</div><div class="col-md-8">' + messageDate[i].text + '</div><div class="col-md-2">' + messageDate[i].time + '</div></div>'
        document.getElementById("homeworkDataList").appendChild(homeworkDateLi);
    }

    // 作业分页
    let homeworkPage = messageDate.length/6;
    if (messageDate.length%6 == 0){
        for (let j = 1;j <= homeworkPage;j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("homeworkPage").append(pageList);
        }
    }else {
        for (let j = 1;j <= Math.ceil(homeworkPage);j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("homeworkPage").appendChild(pageList);
        }
    }
    let pageList = document.createElement('li');
    pageList.innerHTML = '<a href="#" aria-label="Previous"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></a>';
    document.getElementById("homeworkPage").appendChild(pageList);

    // 留言数据填入列表
    for(let i = 0;i < 6;i++){
        let messageDateLi = document.createElement('li');
        messageDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageDate[i].title + '</div><div class="col-md-8">' + messageDate[i].text + '</div><div class="col-md-2">' + messageDate[i].time + '</div></div>'
        document.getElementById("messageDateList").appendChild(messageDateLi);
    }

    // 留言分页
    let messagePage = messageDate.length/6;
    if (messageDate.length%6 == 0){
        for (let j = 1;j <= messagePage;j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("messagePage").append(pageList);
        }
    }else {
        for (let j = 1;j <= Math.ceil(messagePage);j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("messagePage").appendChild(pageList);
        }
    }
    let messagePageList = document.createElement('li');
    messagePageList.innerHTML = '<a href="#" aria-label="Previous"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></a>';
    document.getElementById("messagePage").appendChild(messagePageList);

    // 公告数据填入列表
    for(let i = 0;i < 6;i++){
        let noticeDateLi = document.createElement('li');
        noticeDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageDate[i].title + '</div><div class="col-md-8">' + messageDate[i].text + '</div><div class="col-md-2">' + messageDate[i].time + '</div></div>'
        document.getElementById("noticeDateList").appendChild(noticeDateLi);
    }

    // 公告分页
    let noticePage = messageDate.length/6;
    if (messageDate.length%6 == 0){
        for (let j = 1;j <= noticePage;j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("noticePage").append(pageList);
        }
    }else {
        for (let j = 1;j <= Math.ceil(noticePage);j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("noticePage").appendChild(pageList);
        }
    }
    let noticePageList = document.createElement('li');
    noticePageList.innerHTML = '<a href="#" aria-label="Previous"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></a>';
    document.getElementById("noticePage").appendChild(noticePageList);

    // 隔行换色
    for (let j = 0;j < listColor.length;j++){
        for (let i = 0;i < listColor[j].children.length;i++){
            if (i%2==1){
                listColor[j].children[i].children[0].style.backgroundColor = "white";
            }
        }
    }
}

// 点击换页
function paging(page) {
    // 删除<li>
    for (let i = 0;i < 6;i++){
        let messageUl = document.getElementById("messageDateList");
        let messageLi = messageUl.querySelectorAll("li");
        for (i = 1;i <= 6;i++){
            messageLi[i].remove();
        }
    }
    // 新增<li>
    for(let j = page*6-6;j < page*6;j++){
        let messageDateLi = document.createElement('li');
        if (j%2==0){
            messageDateLi.innerHTML = '<div class="row" style="background-color: white"><div class="col-md-2">' + messageDate[j].title + '</div><div class="col-md-8">' + messageDate[j].text + '</div><div class="col-md-2">' + messageDate[j].time + '</div></div>';
        }else{
            messageDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageDate[j].title + '</div><div class="col-md-8">' + messageDate[j].text + '</div><div class="col-md-2">' + messageDate[j].time + '</div></div>';
        }
        document.getElementById("messageDateList").appendChild(messageDateLi);
    }
    console.log(1);
}

