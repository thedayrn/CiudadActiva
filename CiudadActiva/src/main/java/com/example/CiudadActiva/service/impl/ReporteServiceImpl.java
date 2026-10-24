package com.example.CiudadActiva.service.impl;

import com.example.CiudadActiva.dto.ReporteCreateDTO;
import com.example.CiudadActiva.dto.ReporteResponseDTO;
import com.example.CiudadActiva.dto.UbicacionDTO;
import com.example.CiudadActiva.exception.ResourceNotFoundException;
import com.example.CiudadActiva.model.CategoriaIncidencia;
import com.example.CiudadActiva.model.Reporte;
import com.example.CiudadActiva.model.Ubicacion;
import com.example.CiudadActiva.model.Usuario;
import com.example.CiudadActiva.repository.CategoriaIncidenciaRepository;
import com.example.CiudadActiva.repository.ReporteRepository;
import com.example.CiudadActiva.repository.UsuarioRepository;
import com.example.CiudadActiva.service.ReporteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaIncidenciaRepository categoriaRepository;

    public ReporteServiceImpl(ReporteRepository reporteRepository,
                              UsuarioRepository usuarioRepository,
                              CategoriaIncidenciaRepository categoriaRepository) {
        this.reporteRepository = reporteRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // aquí siguen los métodos crear, listar y toResponse

    @Override
    @Transactional
    public ReporteResponseDTO crear(ReporteCreateDTO dto) {
        Usuario ciudadano = usuarioRepository.findById(dto.ciudadanoId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuario no encontrado con id " + dto.ciudadanoId()));

        CategoriaIncidencia categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoría no encontrada con id " + dto.categoriaId()));

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setLatitud(dto.ubicacion().latitud());
        ubicacion.setLongitud(dto.ubicacion().longitud());
        ubicacion.setDireccion(dto.ubicacion().direccion());
        ubicacion.setReferencia(dto.ubicacion().referencia());

        Reporte reporte = new Reporte();
        reporte.setTitulo(dto.titulo());
        reporte.setDescripcion(dto.descripcion());
        reporte.setCiudadano(ciudadano);
        reporte.setCategoria(categoria);
        reporte.setUbicacion(ubicacion);

        return toResponse(reporteRepository.save(reporte));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReporteResponseDTO> listar() {
        return reporteRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private ReporteResponseDTO toResponse(Reporte r) {
        Ubicacion u = r.getUbicacion();
        UbicacionDTO ubicacionDTO = new UbicacionDTO(
                u.getLatitud(), u.getLongitud(), u.getDireccion(), u.getReferencia());

        return new ReporteResponseDTO(
                r.getId(),
                r.getTitulo(),
                r.getDescripcion(),
                r.getEstado(),
                r.getPrioridad(),
                r.getMotivoRechazo(),
                r.getCiudadano().getNombre(),
                r.getCategoria().getNombre(),
                ubicacionDTO,
                r.getFechaCreacion());
    }
}