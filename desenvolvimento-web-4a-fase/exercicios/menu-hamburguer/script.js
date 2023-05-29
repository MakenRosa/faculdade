let hamburguer = document.querySelector(".hamburguer")
let menu = document.querySelector(".nav-menu")

hamburguer.addEventListener("click", () => {
    hamburguer.classList.toggle("active")
    menu.classList.toggle("active")
})

let right = document.querySelector(".right")
let left = document.querySelector(".left")
let container = document.querySelector(".container")
let container_position = 0
hide_buttons()

function hide_buttons() {
    if (container_position == 0) {
        left.style.visibility = "hidden"
    } else if (container_position == container.children.length - 1) {
        right.style.visibility = "hidden"
    } else {
        left.style.visibility = "visible"
        right.style.visibility = "visible"
    }
}

right.addEventListener("click", () => {
    if (container_position < container.children.length - 1) {
        container_position++
        container.style.transform = `translateX(-${container_position * 100}%)`
        hide_buttons()
    }
})

left.addEventListener("click", () => {
    if (container_position > 0) {
        container_position--
        container.style.transform = `translateX(-${container_position * 100}%)`
        hide_buttons()
    }
})
