function daysSinceUpdate() {
    var date1 = new Date('01/06/2020');
    var date2 = new Date(Date.now());
    var diffDays = date2.getDate() - date1.getDate();
    xxx = diffDays;
    console.log("It works");
    if (document.getElementById) {
        document.write('<span id="dayCount">' + xxx + '</span>');
        storeText = document.getElementById("highlight")
    } else {
        document.write(text);
    }
}