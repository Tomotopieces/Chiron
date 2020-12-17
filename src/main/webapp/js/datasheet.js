$(() => {
    $('.datasheet li').map((index, row) => {
        if (index % 2) {
            $(row).css('background-color', '#E6E6E6');
        }
    });
});