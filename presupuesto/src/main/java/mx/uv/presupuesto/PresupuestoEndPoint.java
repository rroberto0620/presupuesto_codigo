package mx.uv.presupuesto;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.presupuesto.SolicitarPagoPresupuestoRequest;
import mx.uv.t4is.presupuesto.SolicitarPagoPresupuestoResponse;

@Endpoint
public class PresupuestoEndPoint {
    @PayloadRoot(localPart = "SolicitarPagoPresupuestoRequest", namespace = "t4is.uv.mx/presupuesto")
    @ResponsePayload
    public SolicitarPagoPresupuestoResponse solicitarPagoPresupuesto (@RequestPayload SolicitarPagoPresupuestoRequest presupuesto){
        SolicitarPagoPresupuestoResponse response = new SolicitarPagoPresupuestoResponse();
        double total = presupuesto.getCantidad() * presupuesto.getPrecio();
        if(total <= presupuesto.getPresupuesto())
            response.setStatus(true);
        else
            response.setStatus(false);
        return response;
    }

}

