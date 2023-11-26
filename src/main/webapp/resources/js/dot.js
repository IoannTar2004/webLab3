function createDot(data) {
    let val = data.querySelector('td').outerHTML.match(/-?\d+\.\d+|-?\d+/g)
    if (val === null)
        return

    let x = val[1]
    let y = val[2]
    let r = document.getElementById("form:inputR").value
    let color
    if (data.querySelectorAll('td')[1].innerText === 'HIT') {
        color = 'lime';
    } else {
        color = 'red';
    }

    const w = 123 + x/r*90;
    const h = 124 - y/r*90;
    let canvas = document.getElementById('dots');
    if (w > 0 && w < 250 && h > 0 && h < 250) {
        canvas.innerHTML += `<div class="dot" style="margin-left: ${w}px; margin-top: ${h}px; background: ${color}">`;
    }
}

function clearDots() {
    let dots = document.getElementById('dots');
    dots.innerHTML = ''
}
function changeDot() {
    clearDots()

    let outer = document.querySelector("#form\\:results tbody");
    for (let data of outer.querySelectorAll('tr')) {
        createDot(data);
    }
}

function addDot() {
    let last = document.querySelectorAll("#form\\:results tbody tr")
    createDot(last[last.length - 1])
}

changeDot()
