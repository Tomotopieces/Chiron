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

    // 班级数据填入列表
    for(let i = 0;i < 6;i++){
        let homeworkDateLi = document.createElement('li');
        homeworkDateLi.innerHTML = '<div class="row"><div class="col-md-3">' + messageDate[i].title + '</div><div class="col-md-6">' + messageDate[i].text + '</div><div class="col-md-3"><button type="button" class="btn btn-danger">删除</button></div></div>'
        document.getElementById("classDataList").appendChild(homeworkDateLi);
    }

    // 班级分页
    let classPage = messageDate.length/6;
    if (messageDate.length%6 == 0){
        for (let j = 1;j <= classPage;j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("classPage").append(pageList);
        }
    }else {
        for (let j = 1;j <= Math.ceil(homeworkPage);j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("classPage").appendChild(pageList);
        }
    }
    let pageList = document.createElement('li');
    pageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("classPage").appendChild(pageList);

    // 教师数据填入列表
    for(let i = 0;i < 6;i++){
        let teacherDateLi = document.createElement('li');
        teacherDateLi.innerHTML = '<div class="row"><div class="col-md-4">' + messageDate[i].title + '</div><div class="col-md-4">' + messageDate[i].text + '</div><div class="col-md-4"><button type="button" class="btn btn-danger">删除</button></div></div>'
        document.getElementById("teacherDataList").appendChild(teacherDateLi);
    }

    // 教师分页
    let teacherPage = messageDate.length/6;
    if (messageDate.length%6 == 0){
        for (let j = 1;j <= teacherPage;j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("teacherPage").append(pageList);
        }
    }else {
        for (let j = 1;j <= Math.ceil(teacherPage);j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("teacherPage").appendChild(pageList);
        }
    }
    let teacherPageList = document.createElement('li');
    teacherPageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("teacherPage").appendChild(teacherPageList);

    // 学生数据填入列表
    for(let i = 0;i < 6;i++){
        let studentDateLi = document.createElement('li');
        studentDateLi.innerHTML = '<div class="row"><div class="col-md-4">' + messageDate[i].title + '</div><div class="col-md-4">' + messageDate[i].text + '</div><div class="col-md-4"><button type="button" class="btn btn-danger">删除</button></div></div>'
        document.getElementById("studentDataList").appendChild(studentDateLi);
    }

    // 学生分页
    let studentPage = messageDate.length/6;
    if (messageDate.length%6 == 0){
        for (let j = 1;j <= studentPage;j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("studentPage").append(pageList);
        }
    }else {
        for (let j = 1;j <= Math.ceil(studentPage);j++){
            let pageList = document.createElement('li');
            pageList.innerHTML = '<a href="#" onclick="paging(' + j + ')">'+j+'</a>';
            document.getElementById("studentPage").appendChild(pageList);
        }
    }
    let studentPageList = document.createElement('li');
    studentPageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("studentPage").appendChild(studentPageList);

    // 公告数据填入列表
    for(let i = 0;i < 6;i++){
        let noticeDateLi = document.createElement('li');
        noticeDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageDate[i].title + '</div><div class="col-md-6">' + messageDate[i].text + '</div><div class="col-md-2">' + messageDate[i].time + '</div><div class="col-md-2"><button type="button" class="btn btn-danger">删除</button></div></div>'
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
    noticePageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("noticePage").appendChild(noticePageList);

    // 留言数据填入列表
    for(let i = 0;i < 6;i++){
        let messageDateLi = document.createElement('li');
        messageDateLi.innerHTML = '<div class="row"><div class="col-md-2">' + messageDate[i].title + '</div><div class="col-md-6">' + messageDate[i].text + '</div><div class="col-md-2">' + messageDate[i].time + '</div><div class="col-md-2"><button type="button" class="btn btn-danger">删除</button></div></div>'
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
    messagePageList.innerHTML = '<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
    document.getElementById("messagePage").appendChild(messagePageList);

    // 隔行换色
    for (let j = 0;j < listColor.length;j++){
        for (let i = 0;i < listColor[j].children.length;i++){
            if (i%2==1){
                listColor[j].children[i].children[0].style.backgroundColor = "white";
            }
        }
    }

}