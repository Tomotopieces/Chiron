let pageSize = 5;
let maxPageButtonAmount = 5;

/**
 * 生成翻页按钮组, 页码按钮数量最多为 pageButtonAmount
 * 
 * @param {string} servlet Servlet
 * @param {string} countBehavior 动作, 需要返回一个数据长度
 * @param {string} listBehavior 动作, 需要返回一个数据数组
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
                    $(button).on('click', () => { // 设置按钮事件
                        turnPage(servlet, listBehavior, pageNo, fillFunction, maxPageNo);
                    });
                }
                $('#page1').removeClass('btn-default');
                $('#page1').addClass('btn-primary');
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
 * @param {function} fillFunction 数据填写函数
 * @param {number} maxPageNo 最大页码
 */
function turnPage(servlet, behavior, pageNo, fillFunction, maxPageNo) {
    $.post({ // 获取新页数据表并填入表单
        url: servlet,
        data: {
            behavior: behavior,
            pageNo: pageNo,
            pageSize: 5
        },
        success: json => {
            let wrapper = JSON.parse(json);
            let data = JSON.parse(wrapper.data);
            if (wrapper.result) {
                // 更换'当前页'样式
                $('.pageButton').removeClass('btn-primary');
                $('#page' + pageNo).addClass('btn-primary');

                // 首尾页判断, 更新 '上一页' 与 '下一页' 按钮状态
                let $preButton = $('#previousPageButton');
                let $nextButton = $('#nextPageButton');
                if (pageNo == 1) {
                    $preButton.attr('disabled', true);
                } else {
                    $preButton.attr('disabled', false);
                }
                if (pageNo == maxPageNo) {
                    $nextButton.attr('disabled', true);
                } else {
                    $nextButton.attr('disabled', false);
                }

                fillFunction(data); // 数据填写
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '数据获取失败',
                });
            }
        }
    });
}