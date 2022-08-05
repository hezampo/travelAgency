$("#id_from").change(function () {
    var id_ruta = $("#id_from").val();
    const API_URL = "http://localhost:8080/v1/api/load";
    const xhr = new XMLHttpRequest();
    function onRequestHandler(){
        if(this.readyState == 4 && this.status == 200){
            const data = JSON.parse(this.response);
            const HTMLResponse = document.querySelector("#id_to");
            const tpl = data.map((ruta) => `<option value="${ruta.id_to}">${ruta.nombre}</option>`);
            HTMLResponse.innerHTML = tpl;
            console.log(data);
        }
    }
    xhr.addEventListener('load', onRequestHandler);
    xhr.open('GET', `${API_URL}/`+id_ruta);
    xhr.send();
});

