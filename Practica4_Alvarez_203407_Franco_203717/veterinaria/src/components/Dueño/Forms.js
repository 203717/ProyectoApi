import {useEffect, useState} from "react";

const aux = {
    duenoId: null,
    nombre:"",
    direccion:"",
    telefono:""
}

const Forms = (props) =>{
    const [formu,setFormu] = useState([])

    useEffect(() => {

        if(props.edit){
            setFormu(props.edit)
        }else{
            setFormu(aux)
        }

    },[props.edit])


    const handleChange = (e) =>{
        setFormu({
            ...formu,[e.target.name] : e.target.value,
        });
    }


    const handleSubmit = (e) =>{
        e.preventDefault()

        if(!formu.nombre || !formu.direccion){
            alert("Campos vacios")
            return;
        }

        if(formu.duenoId === null){
            props.addDueno(formu)
        }
        else{
            props.updateDueno(formu)
        }
        handleReset()
    }


    const handleReset =  (e) =>{
        setFormu(aux);
        props.setEdit(null)
    }


    return(
        <div>
            <form onSubmit={handleSubmit} className="fr" >
                <input  type= "text"  name="nombre" placeholder="Nombre" onChange={handleChange} value={formu.nombre} />
                <input type= "text"  name="direccion" placeholder="Direccion" onChange={handleChange} value={formu.direccion}/>
                <input  type= "text"  name="telefono" placeholder="Telefono" onChange={handleChange} value={formu.telefono}/>

                <input type="submit" value="Enviar" />
                <input type="reset" value="Limpiar" onClick={handleReset}/>

            </form>


        </div>
    )
}

export default Forms;