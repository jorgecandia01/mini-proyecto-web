let sugerencias = [];

//Añado un listener con jquery sobre el botón para obtener la sugerencia del campo de input
const initListeners = () =>{ //si no hago esto no me va
    $("#btnEnviar").on("click", () => {
        //console.log("hola listener")
        let sugerencia = $("#txtSugerencia").val();
        //console.log("Listener debug:" + sugerencia + "////" + typeof(sugerencia));
        if(sugerencia.trim() !== ""){postSugerencia(sugerencia)};
    });
}


//Función para hacer un POST de una sugerencia
const postSugerencia = async (sugerencia) => {
    let request = await fetch("/postSugerencia",{
    method : "POST",
    body : JSON.stringify({id: 454, cuerpo: sugerencia}),
    credentials: "same-origin",
    headers: {"Content-Type": "application/json",}, // Indico que mis datos van a estar en JSON
    dataType: "json",});

    //console.log("Fetch debug:" + sugerencia);

    if(request.status === 200){
        console.log("Sugerencia enviada correctamente");
        $("#postSuccess").removeClass("d-none");
        $("#postError").addClass("d-none");
    } else {
        console.log("Error al enviar la sugerencia");
        $("#postSuccess").addClass("d-none");
        $("#postError").removeClass("d-none");
    }
}


//Función para hacer un GET de todas las sugerencias
const getSugerencias = async () => {
    let request = await fetch("/getSugerencias");
    if(request.status === 200){
        console.log("Sugerencias obtenidas con éxito");
        let data = await request.json();
        data.forEach((sugerencia) => sugerencias.push(sugerencia));
        console.log(sugerencias);
    } else {
        console.log("Error al obtener las sugerencias");
    }
}
























