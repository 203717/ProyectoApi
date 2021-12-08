import '../../index.css';


const Tabla = (props) => {

    return (
        <div>
            <table class="table table-hover" id={"tab"}>
                <thead>
                <tr>
                    <th>Hora</th>
                    <th>Servicio</th>
                    <th>Fecha</th>
                    <th>MascotaId</th>
                </tr>
                </thead>

                <tbody>

                {props.datos.length === 0 ? <tr><td colSpan="3">Sin datos</td> </tr>: props.datos.map(item =>
                        <tr key={item.citaId}>

                            <td>{item.hora}</td>
                            <td>{item.servicio}</td>
                            <td>{item.fecha}</td>
                            <td>{item.mascotaId}</td>

                            <td>
                                <button onClick={()=> props.setd(item)} >Editar</button>
                                <button  onClick={() => props.del(item.citaId)}> Eliminar</button>
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
