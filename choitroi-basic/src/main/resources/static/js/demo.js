function selectCountry() {
    var a = document.getElementById("input").value;
    if (a === "Đà Nẵng") {
        var arr = ["Quận Hải Châu", "Quận Thanh Khê", "Quận Sơn Trà", "Quận Ngũ Hành Sơn", "Quận Liên Chiểu", "Huyện Hòa Vang", "Quận Cẩm Lệ"];
    } else if (a === "USA") {
        var arr = ["Washington", "Texas", "New York"];
    }

    var string = "";

    for (i = 0; i < arr.length; i++) {
        string = string + "<option value=" + arr[i] + ">" + arr[i] + "</option>";
    }
    document.getElementById("output").innerHTML = string;
}