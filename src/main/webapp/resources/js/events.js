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

            document.getElementById("form:inputR").value = i
            changeDot()
        })
    }
}

// function errorsClear() {
//     document.body.addEventListener("click", () => {
//         document.getElementById("form:errorY").innerHTML = ""
//     })
// }

function targetDot() {
    document.getElementById('canvas').addEventListener('mouseenter', () => {
        document.getElementById('fixed-dot').style.display = 'block';
        window.addEventListener('mousemove', e => {
            const el = document.querySelector('#fixed-dot');
            el.style.left = e.pageX + 'px'
            el.style.top = e.pageY + 'px';

            let r = document.getElementById("form:inputR").value
            let x = (r * (e.pageX - 243) / 90);
            let y = (r * (e.pageY - 444) / -90);

            if (x - Math.floor(x) >= 0.95 || x - Math.floor(x) <= 0.05) {
                x = Math.round(x);
            }
            if (y - Math.floor(y) >= 0.95 || y - Math.floor(y) <= 0.05) {
                y = Math.round(y);
            }
            document.getElementById("form:x").value = x.toFixed(2);
            document.getElementById("form:y").value = y.toFixed(2);
        })
    })

    document.getElementById('canvas').addEventListener('mouseleave', () => {
        document.getElementById('fixed-dot').style.display = 'none';
    })
}

targetDot()
buttonsInit()
errorsClear()