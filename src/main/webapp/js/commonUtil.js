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