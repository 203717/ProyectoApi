import {useEffect, useState} from "react";

const aux = {
    citaId: null,
    hora:"",
    servicio:"",
    fecha:"",
    mascotaId:""
}


const Forms = (props) =>{
    const [formu,setFormu] = useState(aux)

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

        if(!formu.hora || !formu.servicio){
            alert("Campos vacios")
            return;
        }

        if(formu.citaId === null){
            props.addCita(formu)
        }
        else{
            props.updateCita(formu)
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

                <input  type= "text"  name="hora" placeholder="hora" onChange={handleChange} value={formu.hora} />
                <input type= "text"  name="servicio" placeholder="servicio" onChange={handleChange} value={formu.servicio}/>
                <input  type= "text"  name="fecha" placeholder="fecha" onChange={handleChange} value={formu.fecha}/>
                <input  type= "text"  name="mascotaId" placeholder="mascotaId" onChange={handleChange} value={formu.mascotaId}/>

                <input type="submit" value="Enviar" />
                <input type="reset" value="Limpiar" onClick={handleReset}/>

            </form>


        </div>
    )
}

export default Forms;