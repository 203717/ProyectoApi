import {useEffect, useState} from "react";

const aux = {
    tipoid: null,
    tipo:"",
    caracteristica:"",
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

        if(!formu.tipo || !formu.caracteristica){
            alert("Campos vacios")
            return;
        }

        if(formu.tipoid === null){
            props.addTipo(formu)
        }
        else{
            props.updateTipo(formu)
        }
        handleReset()
    }


    const handleReset =  (e) =>{
        setFormu(aux);
        props.setEdit(null)
    }


    return(
        <div>
            <form onSubmit={handleSubmit} className="fr">
                <input  type= "text"  name="tipo" placeholder="tipo" onChange={handleChange} value={formu.tipo} />
                <input type= "text"  name="caracteristica" placeholder="caracteristica" onChange={handleChange} value={formu.caracteristica}/>

                <input type="submit" value="Enviar" />
                <input type="reset" value="Limpiar" onClick={handleReset}/>

            </form>


        </div>
    )
}

export default Forms;