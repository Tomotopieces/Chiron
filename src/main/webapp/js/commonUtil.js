/**
 * 设置当前用户名
 */
function setCurrentUsername() {
    $.post({
        url: '../../user.do',
        data: {
            behavior: 'getUser'
        },
        success: json => {
            let wrapper = JSON.parse(json);
            let user = JSON.parse(wrapper.data);
            if (wrapper.result) {
                $('#currentUsername').text(user.username);
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '获取用户名失败'
                });
            }
        }
    });
}

/**
 * 将班级id替换为班级名
 */
function classIdToName() {
    $('.className').map((index, element) => {
        console.log(index + ' ' + element);
        let $element = $(element);
        let classId = $element.text();
        $.post({
            url: 'admin.class.do',
            data: {
                behavior: 'getClass',
                classId: classId
            },
            success: json => {
                let wrapper = JSON.parse(json);
                let data = JSON.parse(wrapper.data);
                if (wrapper.result) {
                    $element.text(data.className);
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: '获取班级名失败'
                    });
                }
            }
        });
    });
}