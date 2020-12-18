


/**
 * 表内填充公告数据
 *
 * @param {Notice[]} dataList 公告数据表
 */
function fillNoticeSheet(dataList) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-2">标题</div>' +
        '<div class="col-md-8">公告内容</div>' +
        '<div class="col-md-2">创建时间</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="classId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.title + '</div>' +
            '<div class="col-md-8">' + data.content + '</div>' +
            '<div class="col-md-2">' + data.create_time + '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
}

/**
 * 表内填充留言数据
 *
 * @param {Message[]} dataList 留言数据表
 */
function fillNoticeSheet(dataList) {
    $datasheet.empty(); // 清空现存数据
    let $ul = $('<ul></ul>'); // 重新设置无序列表

    // 表头
    let head =
        '<li class="datasheetHead">' +
        '<div class="col-md-2">标题</div>' +
        '<div class="col-md-8">留言内容</div>' +
        '<div class="col-md-2">发布时间</div>' +
        '<br>' +
        '</li>';
    $ul.append(head);

    // '添加'行
    let addRow =
        '<li class="datasheetRow">' +
        '<form id="addForm">' +
        '<input type="hidden" name="behavior" value="leaveMessage">' +
        '<div class="col-md-2"><input id="classNo" name="classNo" type="text" size="10" placeholder="标题"></div>' + // title
        '<div class="col-md-8"><input id="className" name="className" type="text" size="10" placeholder="公告内容"></div>' + // content
        '</form>' +
        '<div class="col-md-2">' +
        '<button id="addButton" type="button" class="operate btn btn-success">添加</button>' +
        '</div>' +
        '<br>' +
        '</li>';
    $ul.append(addRow);
    bindAddButtonEvent();

    // 数据行
    for (let i = 0; i < dataList.length; i++) {
        let data = dataList[i];
        let row =
            '<li class="datasheetRow">' +
            '<div class="classId" style="display: none;">' + data.id + '</div>' +
            '<div class="col-md-2">' + data.title + '</div>' +
            '<div class="col-md-8">' + data.content + '</div>' +
            '<div class="col-md-2">' + data.create_time + '</div>' +
            '<br>' +
            '</li>';
        $ul.append(row);
    }

    $datasheet.append($ul);
}