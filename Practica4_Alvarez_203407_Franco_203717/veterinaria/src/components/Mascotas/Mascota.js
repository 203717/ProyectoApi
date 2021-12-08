import {useEffect, useState} from "react";
import Forms from "../Dueño/Forms";
import Tabla from "./Tabla";
import Form from "./Form";


//const urlGet = 'http://localhost:18080/listDuenos'
const urlGet = 'http://localhost:28080/duenoMascota'
const urlPostAdd = 'http://localhost:28080/mascota/add'
const urlPut = 'http://localhost:28080/mascota/update'
const urlDel = 'http://localhost:28080/mascota/delete'


const Dueños = () => {
    const [datos, setData] = useState([])
    const [edit,setEdit] = useState(null)


    const addMascota = (dat) => {

        const peticion = {
            method: 'POST',
            body: JSON.stringify(dat),
            headers: {
                "Content-type": "application/json"
            }
        }
        post(peticion)
    }

    const updateMascota = (dat) => {
        const peticion = {
            method: 'PUT',
            body: JSON.stringify(dat),
            headers: {
                "Content-type": "application/json"
            }
        }
        put(peticion)
    }

    const deleteMascota = (dat) => {
        const peticion = {
            method: 'DELETE',
            body: JSON.stringify(dat),
            headers: {
                "Content-type": "application/json"
            }
        }
        del(peticion)
    }


    useEffect(() => {
        get()
    }, []);

    const post = async (peticion)  => {
        const dato = await fetch(urlPostAdd,peticion)
        get()
    }

    const get = async ()  => {
        const dato = await fetch(urlGet)
        const mascota =   await dato.json()
        setData(mascota)
    }

    const put = async (peticion)  => {
        const dato = await fetch(urlPut,peticion)
        get()
    }

    const del = async (peticion)  => {
        const dato = await fetch(urlDel,peticion)
        get()
    }

    return(
        <div>
            <Form addMascota={addMascota} updateMascota={updateMascota}   edit={edit}   setEdit={setEdit} setData={setData} ></Form>

            <Tabla masc={datos}   setd={setEdit} del={deleteMascota}  ></Tabla>

        </div>
    )
}

export default Dueños;