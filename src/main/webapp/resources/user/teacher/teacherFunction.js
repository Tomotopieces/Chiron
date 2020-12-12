let messageData = [
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

    // 布置作业数据填入列表
    for(let i = 0;i < 6;i++){
        let homeworkDateLi = document.createElement('li');
        homeworkDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageData[i].title + '</div><div class="col-md-6">' + messageData[i].text + '</div><div class="col-md-2">' + messageData[i].time + '</div><div class="col-md-2"><button type="button" class="btn btn-danger">删除</button></div>'
        document.getElementById("assignHomeworkDataList").appendChild(homeworkDateLi);
    }

    // 布置作业分页
    let assignHomeworkPage = messageData.length/6;
    if (messageData.length%6 == 0){
        for (let j = 1;j <= assignHomeworkPage;j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("assignHomeworkPage").append(pageList);
        }
    }else {
        for (let j = 1;j <= Math.ceil(assignHomeworkPage);j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("assignHomeworkPage").appendChild(pageList);
        }
    }
    let assignPageList = document.createElement('li');
    assignPageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("assignHomeworkPage").appendChild(assignPageList);

    // 学生作业数据填入列表
    for(let i = 0;i < 6;i++){
        let homeworkDateLi = document.createElement('li');
        homeworkDateLi.innerHTML = '<div class="row"><div class="col-md-3">' + messageData[i].title + '</div><div class="col-md-3">' + messageData[i].text + '</div><div class="col-md-3"><a>作业</a></div><div class="col-md-3">' + messageData[i].time + '</div></div>'
        document.getElementById("studentHomeworkDataList").appendChild(homeworkDateLi);
    }

    // 学生作业分页
    let studentHomeworkPage = messageData.length/6;
    if (messageData.length%6 == 0){
        for (let j = 1;j <= studentHomeworkPage;j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("studentHomeworkDataPage").append(pageList);
        }
    }else {
        for (let j = 1;j <= Math.ceil(studentHomeworkPage);j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("studentHomeworkDataPage").appendChild(pageList);
        }
    }
    let studentPageList = document.createElement('li');
    studentPageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("studentHomeworkDataPage").appendChild(studentPageList);

    // 留言数据填入列表
    for(let i = 0;i < 6;i++){
        let messageDateLi = document.createElement('li');
        messageDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageData[i].title + '</div><div class="col-md-8">' + messageData[i].text + '</div><div class="col-md-2">' + messageData[i].time + '</div><div class="col-md-2"></div></div>'
        document.getElementById("messageDateList").appendChild(messageDateLi);
    }

    // 留言分页
    let messagePage = messageData.length/6;
    if (messageData.length%6 == 0){
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
    messagePageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("messagePage").appendChild(messagePageList);

    // 公告数据填入列表
    for(let i = 0;i < 6;i++){
        let noticeDateLi = document.createElement('li');
        noticeDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageData[i].title + '</div><div class="col-md-8">' + messageData[i].text + '</div><div class="col-md-2">' + messageData[i].time + '</div><div class="col-md-2"></div></div>'
        document.getElementById("noticeDateList").appendChild(noticeDateLi);
    }

    // 公告分页
    let noticePage = messageData.length/6;
    if (messageData.length%6 == 0){
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
    noticePageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("noticePage").appendChild(noticePageList);

    for (let j = 0;j < listColor.length;j++){
        for (let i = 0;i < listColor[j].children.length;i++){
            if (i%2==1){
                listColor[j].children[i].children[0].style.backgroundColor = "white"
            }
        }
    }
}