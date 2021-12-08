import '../../index.css';


let nombres = ""

function  getNombre(item){

    if(item.mascotas != null){
        (item.mascotas.map(it =>
            nombres += it.nombre + ","))
        return nombres
    }else{
        return nombres = "sin mascotas";
    }
}


const Tabla = (props) => {

    return (
        <div>
            <table class="table table-hover" id={"tab"}>
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Mascotas</th>
                </tr>
                </thead>

                <tbody>

                {props.datos === [] ? <tr><td colSpan="3">Sin datos</td> </tr>: props.datos.map(item =>
                        <tr key={item.duenoId}>
                            <td>{item.nombre}</td>
                            <td>{item.direccion}</td>
                            <td>{item.telefono}</td>

                            <td>{getNombre(item) }</td>
                            {nombres = ""}

                            <td>
                                <button onClick={()=> props.setd(item)} >Editar</button>
                                <button  onClick={() => props.del(item)}> Eliminar</button>
                            </td>
                        </tr>
                    )
                }
                </tbody>

            </table>
        </div>

    )
}

export default Tabla;
