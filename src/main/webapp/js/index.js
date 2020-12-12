$(() => {
    console.log('jQuery code loading.');
    $('#mainContainer').fadeIn('slow');

    $('#loginButton').on('click', () => {
        if (!inputEmptyCheck()) {
            return;
        }

        $.post({
            url: 'user.do',
            data: $('#loginForm').serialize(),
            success: json => {
                let wrapper = JSON.parse(json);
                let data = wrapper.data;
                wrapper.result ?
                    window.location.href = data :
                    Swal.fire({
                        icon: 'error',
                        title: data,
                        showConfirmButton: false,
                        timer: 2000
                    });
            }
        });
    });
});

function inputEmptyCheck() {
    if ($('#username').val() == "") {
        Swal.fire({
            icon: 'warning',
            title: '请输入用户名',
            showConfirmButton: false,
            timer: 2000
        });
        return false;
    } else if ($('#password').val() == "") {
        Swal.fire({
            icon: 'warning',
            title: '请输入密码',
            showConfirmButton: false,
            timer: 2000
        });
        return false;
    }
    return true;
}
