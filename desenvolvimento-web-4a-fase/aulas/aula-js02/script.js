let item = document.querySelectorAll('.item');
let contentItem = document.querySelectorAll('.content-item');

for (let i = 0; i < item.length; i++) {
    item[i].addEventListener('click', function () {
        if (!item[i].classList.contains('active')) {

            item[i].classList.toggle('active');
            contentItem[i].classList.toggle('active');
        }
        for (let j = 0; j < item.length; j++) {
            if (j != i) {
                item[j].classList.remove('active');
                contentItem[j].classList.remove('active');
            }
        }
    });
}

