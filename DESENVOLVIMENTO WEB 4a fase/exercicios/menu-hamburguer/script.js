let hamburguer = document.querySelector('.hamburguer');
let menu = document.querySelector('.nav-menu');
let isAnimating = false;

hamburguer.addEventListener('click', () => {
    menu.classList.toggle('active');
    for (let i = 0; i < hamburguer.children.length; i++) {
        hamburguer.children[i].getAnimations().forEach(anim => {
            if (menu.classList.contains('active')) {
                anim.play();
            } else {
                anim.reverse();
            }
        });
    }
})


let right = document.querySelector('.right');
let left = document.querySelector('.left');
let container = document.querySelector('.container');
let container_position = 0;

right.addEventListener('click', () => {
    if (container_position < container.children.length - 1) {
        container_position++;
        container.style.transform = `translateX(-${container_position * 100}%)`;
    }
});

left.addEventListener('click', () => {
    if (container_position > 0) {
        container_position--;
        container.style.transform = `translateX(-${container_position * 100}%)`;
    }
});
