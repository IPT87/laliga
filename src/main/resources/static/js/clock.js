function updateClock() {
    const now = new Date();
    const hours = now.getHours();
    const minutes = now.getMinutes() < 10 ? 0 + "" + now.getMinutes(): now.getMinutes();;
    const seconds = now.getSeconds() < 10 ? 0 + "" + now.getSeconds(): now.getSeconds();

    const clock = document.getElementById('clock');
    clock.textContent = `${hours}:${minutes}:${seconds}`;
}

updateClock();
setInterval(updateClock, 1000);