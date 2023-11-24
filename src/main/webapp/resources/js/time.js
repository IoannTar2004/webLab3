function clock() {
    let date = new Date();
    const months = ["Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"]
    document.getElementById("table").innerHTML = `${date.getDate()} ${months[date.getMonth()]} ${date.getFullYear()} года`

    let indicators = document.querySelectorAll(".indicator")
    indicators[0].src = `resources/img/indicator/${Math.floor(date.getHours() / 10)}.png`
    indicators[1].src = `resources/img/indicator/${date.getHours() % 10}.png`

    indicators[2].src = `resources/img/indicator/${Math.floor(date.getMinutes() / 10)}.png`
    indicators[3].src = `resources/img/indicator/${date.getMinutes() % 10}.png`

    indicators[4].src = `resources/img/indicator/${Math.floor(date.getSeconds() / 10)}.png`
    indicators[5].src = `resources/img/indicator/${date.getSeconds() % 10}.png`
}

clock()
setInterval(clock, 1000)
