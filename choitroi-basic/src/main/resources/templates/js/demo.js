function selectCountry() {

    var a = document.getElementById("country").value;
    if (a === "Đà Nẵng") {
        var arrDictrict = ["Hải Châu", "Thanh Khê", "Sơn Trà", "Ngũ Hành Sơn", "Liên Chiểu", "Hòa Vang", "Cẩm Lệ"];
    } else {
        var arrDictrict = [];
    }

    var strDictrict = "";

    for (i = 0; i < arrDictrict.length; i++) {
        strDictrict = strDictrict + "<option value=" + arrDictrict[i] + ">" + arrDictrict[i] + "</option>";
    }
    document.getElementById("dictrict").innerHTML = strDictrict;

}

function selectDictrict() {
    var b = document.getElementById("dictrict").value;
    if (b === "Hải Châu") {
        var arrWard = ["Bình Thiên", "Bình Thuận", "Hải Châu I", "Hải Châu II", "Hòa Cường Bắc", "Hòa Cường Nam", "Hòa Thuận Đông", "Hòa Thuận Tây", "Nam Dương", "Phước Ninh", "Thạch Thang", "Thạch Bình", "Thuận Phước"];
    } else {
        var arrWard = [];
    }

    var strWard = "";

    for (i = 0; i < arrWard.length; i++) {
        strWard = strWard + "<option value=" + arrWard[i] + ">" + arrWard[i] + "</option>";
    }
    document.getElementById("ward").innerHTML = strWard;
}