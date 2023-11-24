function buttonsInit() {
    for (let i = 1; i <= 5; i++) {
        document.getElementById("form:r" + i).addEventListener("click", () => {
            document.getElementById("coorRd2_x").innerHTML = String(i / 2)
            document.getElementById("coorR_x").innerHTML = String(i)
            document.getElementById("coorRd2_y").innerHTML = String(i / 2)
            document.getElementById("coorR_y").innerHTML = String(i)
            document.getElementById("coor-Rd2_x").innerHTML = String(i / 2)
            document.getElementById("coor-R_x").innerHTML = String(i)
            document.getElementById("coor-Rd2_y").innerHTML = String(i / 2)
            document.getElementById("coor-R_y").innerHTML = String(i)
        })
    }
}

function errorsClear() {
    document.body.addEventListener("click", () => {
        document.getElementById("form:errorY").innerHTML = ""
    })
}

setInterval(() => {console.log(1)}, 1000)
buttonsInit()
errorsClear()