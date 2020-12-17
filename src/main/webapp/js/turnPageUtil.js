/**
 * 翻页工具函数
 */

let pageSize = 5,               // 每页数据条数
    maxPageButtonAmount = 5,    // 最页码大按钮数
    $preButton,                 // '上一页' 按钮
    $nextButton;                // '下一页' 按钮

/**
 * 数据初始化
 */
$(() => {
    $preButton = $('#previousPageButton');
    $nextButton = $('#nextPageButton');
});

/**
 * 生成翻页按钮组, 页码按钮数量最多为 pageButtonAmount
 * 
 * @param {string} servlet Servlet
 * @param {string} countBehavior 动作, 返回一个数据长度
 * @param {string} listBehavior 动作, 返回一个数据数组
 * @param {function} fillFunction 数据填写函数
 */
function generatePageButtonGroup(servlet, countBehavior, listBehavior, fillFunction) {
    $.post({
        url: servlet,
        data: {
            behavior: countBehavior
        },
        success: json => {
            // 获取后端传来的数据
            let wrapper = JSON.parse(json);
            let length = JSON.parse(wrapper.data);
            if (wrapper.result) {
                // 计算最大页码, 从而确定按钮数量
                let maxPageNo = Math.ceil(length / pageSize);
                let pageButtonAmount = maxPageNo > maxPageButtonAmount ? maxPageButtonAmount : maxPageNo;

                // 插入按钮
                for (let i = 0; i < pageButtonAmount; i++) {
                    let pageNo = i + 1;
                    let button = // '添加页码' 按钮
                        '<button id="page' + pageNo + '" type="button" class="pageButton btn btn-default">' + pageNo + '</button>';
                    $(button).insertBefore(nextPageButton); // 插入
                    $('#page' + pageNo).on('click', event => { // 设置按钮事件
                        turnPage(servlet, listBehavior, parseInt($(event.target).text()), maxPageNo, fillFunction);
                    });
                }

                // 设置第一页为 '当前页' 样式
                $('#page1').removeClass('btn-default');
                $('#page1').addClass('btn-primary');

                // '上一页' 与 '下一页' 可用性检查
                buttonDisableCheck(1, maxPageNo);

                // 绑定 '上一页' 与 '下一页' 点击事件
                $preButton.on('click', () => {
                    let pageNo = parseInt($('.btn-primary').text());
                    turnPage(servlet, listBehavior, pageNo - 1, maxPageNo, fillFunction);
                });
                $nextButton.on('click', () => {
                    let pageNo = parseInt($('.btn-primary').text());
                    turnPage(servlet, listBehavior, pageNo + 1, maxPageNo, fillFunction);
                });
            }
        }
    });
}

/**
 * 翻页, 填写新数据, 更新按钮组
 * 
 * @param {string} servlet Servlet
 * @param {string} behavior 动作
 * @param {number} pageNo 目标页码
 * @param {number} maxPageNo 最大页码
 * @param {function} fillFunction 数据填写函数
 */
function turnPage(servlet, behavior, pageNo, maxPageNo, fillFunction) {
    $.post({ // 获取新页数据表并填入表单
        url: servlet,
        data: {
            behavior: behavior,
            pageNo: pageNo,
            pageSize: pageSize
        },
        success: json => {
            let wrapper = JSON.parse(json);
            let data = JSON.parse(wrapper.data);
            if (wrapper.result) {
                updatePageButtons($('.pageButton'), pageNo, maxPageNo); // 更新数字按钮
                buttonDisableCheck(pageNo, maxPageNo); // '上一页' 与 '下一页' 禁用检查
                fillFunction(data); // 数据填写
                setCrossColor(); // 隔行换色
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '数据获取失败',
                });
            }
        }
    });
}

/**
 * 更新翻页按钮
 * 
 * @param {JQuery} $buttons 数字翻页按钮组
 * @param {number} pageNo 目标页码
 * @param {number} maxPageNo 最大页码
 */
function updatePageButtons($buttons, pageNo, maxPageNo) {
    $buttons.removeClass('btn-primary');
    $buttons.addClass('btn-default');
    $buttons.map((index, button) => {
        let $button = $(button);
        let currentPageNo;

        if (maxPageNo > 5) { // 总页数大于5
            if (pageNo > 3) { // 左侧按钮值需要偏移
                if (pageNo > maxPageNo - 2) { // 右侧按钮值到最大页数
                    currentPageNo = maxPageNo - 4 + index;
                } else { // 右侧按钮值未到最大页数
                    currentPageNo = pageNo - 2 + index;
                }
            } else { // 左侧按钮值不需要偏移
                currentPageNo = 1 + index;
            }
        }

        $button.attr('id', 'page' + currentPageNo);
        $button.text(currentPageNo);
        if (currentPageNo == pageNo) { // 更换 '当前页' 按钮样式
            $button.addClass('btn-primary');
        }
    });
}

/**
 * 首尾页判断, 更新 '上一页' 与 '下一页' 按钮状态
 * 
 * @param {number} pageNo 当前页码
 * @param {number} maxPageNo 最大页数
 */
function buttonDisableCheck(pageNo, maxPageNo) {
    if (pageNo == 1) { // 已经是首页
        $preButton.attr('disabled', true);
    } else {
        $preButton.attr('disabled', false);
    }
    if (pageNo == maxPageNo) { // 已经是尾页
        $nextButton.attr('disabled', true);
    } else {
        $nextButton.attr('disabled', false);
    }
}

/**
 * 设置隔行换色
 */
function setCrossColor() {
    $('.datasheetRow').map((index, row) => {
        if (index % 2) {
            $(row).css('background', '#E6E6E6');
        }
    });
}