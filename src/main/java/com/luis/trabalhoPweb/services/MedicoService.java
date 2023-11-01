package com.luis.trabalhoPweb.services;

import com.luis.trabalhoPweb.dtos.MedicoDTO;
import com.luis.trabalhoPweb.dtos.MedicoMinDTO;
import com.luis.trabalhoPweb.entities.Medico;
import com.luis.trabalhoPweb.repositories.EnderecoRepository;
import com.luis.trabalhoPweb.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;



    @Transactional(readOnly = true)
    private MedicoDTO findById(Long id) {
        Medico result = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico nao encontrado"));
        return new MedicoDTO(result);
    }

    @Transactional(readOnly = true)
    public MedicoDTO searchById(Long id) {
        Medico result = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico nao encontrado"));
        return MedicoDTO.builder()
                .id(result.getId())
                .nome(result.getNome())
                .email(result.getEmail())
                .crm(result.getCrm())
                .especialidade(result.getEspecialidade())
                .build();
    }

    @Transactional(readOnly = true)
    public Page<MedicoMinDTO> findAll(Map<String, String> param, Pageable pageable) {
        String page = Optional.ofNullable(param.get("page")).orElse("0");
        int pageSize = Integer.parseInt(Optional.ofNullable(param.get("size")).orElse("10"));
        String metodoOrdenacao = Optional.ofNullable(param.get("sortBy")).orElse("nome");

        pageable = PageRequest.of(Integer.parseInt(page),pageSize, Sort.by(metodoOrdenacao));
        Page<Medico> result = medicoRepository.findAll(pageable);
        return result.map(MedicoMinDTO::new);
    }

    public MedicoDTO create(MedicoDTO medicoDTO) {
        Medico novoMedico = new Medico(medicoDTO);
        medicoRepository.save(novoMedico);
        return new MedicoDTO(medicoRepository.save(novoMedico));
    }

   public MedicoDTO updateById(Long id, MedicoDTO dto) {
        validaEmailPUTDTO(dto);
        validaCrm(dto);
        validaEspecialidade(dto);

       Medico entidade = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico nao encontrado"));
       entidade.setNome(dto.getNome());
       entidade.setTelefone(dto.getTelefone());
       entidade.setEndereco(dto.getEndereco());

       return new MedicoDTO(medicoRepository.save(entidade));
   }


   public MedicoDTO inativa(Long id) {
       Medico entidade = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico nao encontrado"));
       entidade.setAtivo(false);

       return new MedicoDTO(medicoRepository.save(entidade));
   }
   public void validaEmailPUTDTO(MedicoDTO dto) {
       if(Optional.ofNullable(dto.getEmail()).isPresent()) {
           throw new RuntimeException("Não pode atualizar email");
       }
   }


   public void validaCrm(MedicoDTO dto) {
       if(Optional.ofNullable(dto.getCrm()).isPresent()){
           throw new RuntimeException();
       }
   }

    public void validaEspecialidade(MedicoDTO dto) {
        if(Optional.ofNullable(dto.getEspecialidade()).isPresent()){
            throw new RuntimeException();
        }
    }
}
