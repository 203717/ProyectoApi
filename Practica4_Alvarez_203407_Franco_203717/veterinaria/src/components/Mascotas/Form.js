import React, {useState,useEffect} from "react";

const valin = {
    nombre: "",
    razon:"",
    tipo:"",
    fecha:"",
    duenoId:"",
    mascotaId:null

}

const Form = (props) => {
    const [formulario,setFormulario]= useState([]);

    useEffect(() => {
        if (props.edit){
            setFormulario(props.edit)
        }else {
            setFormulario(valin)
        }
    }, [props.edit]);

    const handleChange = (e) => {
        setFormulario({
            ...formulario,[e.target.name]:e.target.value,
        });

    }

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!formulario.nombre || !formulario.razon ){
            alert("Datos incompletos");
            return;
        }

        if(formulario.mascotaId === null){
            props.addMascota(formulario)
        }
        else{
            console.log(formulario)
            props.updateMascota(formulario)
        }
        handleReset()
    }

    const handleReset = (e) => {
        setFormulario(valin)
        props.setEdit(null)
    }


    return(
        <div>
            <form onSubmit={handleSubmit} className="fr">
                <input  type= "text"  name="nombre" placeholder="Nombre" onChange={handleChange} value={formulario.nombre} />
                <input type= "text"  name="razon" placeholder="Razón" onChange={handleChange} value={formulario.razon}/>
                <input  type= "text"  name="tipo" placeholder="Tipo" onChange={handleChange} value={formulario.tipo}/>
                <input  type= "text"  name="fecha" placeholder="Fecha" onChange={handleChange} value={formulario.fecha}/>
                <input  type= "text"  name="duenoId" placeholder="DueñoID" onChange={handleChange} value={formulario.duenoId}/>

                <input type="submit" value="Enviar"/>
                <input type="reset" value="Limpiar" onClick={handleReset}/>

            </form>





        </div>

    )

}
export default Form;