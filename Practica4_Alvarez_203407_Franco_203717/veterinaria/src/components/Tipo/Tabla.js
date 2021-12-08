import '../../index.css';


const Tabla = (props) => {

    return (
        <div>
            <table  class="table table-hover" id={"tab"}>
                <thead>
                <tr>
                    <th>Tipo</th>
                    <th>Caracteristicas</th>
                    <th>Mascota</th>
                </tr>
                </thead>

                <tbody>

                {props.datos === null ? <tr><td colSpan="3">Sin datos</td> </tr>: props.datos.map(item =>

                        <tr key={item.tipoid}>

                            <td >{item.tipo}</td>
                            <td >{item.caracteristica}</td>
                            <td>{item.mascota != null ? item.mascota.nombre : "Sin mascota"} </td>

                            <td>
                                <button onClick={()=> props.setd(item)} >Editar</button>
                                <button  onClick={() => props.del(item)} > Eliminar</button>
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
