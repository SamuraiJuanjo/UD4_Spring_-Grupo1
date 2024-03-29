package com.example.demo.service.impl;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProFamily;
import com.example.demo.model.ProFamilyModel;
import com.example.demo.repository.ProFamilyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ProFamilyService;

@Configuration
@Service("proFamilyService")
public class ProFamilyServiceImpl implements ProFamilyService {
	
	@Autowired
	@Qualifier("proFamilyRepository")
	private ProFamilyRepository proFamilyRepository;
	
	@Autowired
	@Qualifier("studentRepository")
	private StudentRepository studentRepository;
    
    private ProFamily model2entity(ProFamilyModel proFamilyModel) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(proFamilyModel, ProFamily.class);
	}

	@SuppressWarnings("unused")
	private ProFamilyModel entity2model(ProFamily proFamily) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(proFamily, ProFamilyModel.class);
	}

    @Override
    public ProFamily saveProFamily(ProFamily proFamily) {
        return proFamilyRepository.save(proFamily);
    }

    @Override
	public int deleteProFamily(int id) {
		ProFamily optionalProFamily = proFamilyRepository.findById(id);
        	ProFamily proFamily = optionalProFamily;
        	proFamily.setDeleted(1);
            proFamilyRepository.save(proFamily);
            return 1;
    }

    @Override
    public ProFamily updateProFamily(ProFamily proFamilyM) {
        ProFamily proFamily = proFamilyRepository.findById(proFamilyM.getId());
        proFamily.setName(proFamilyM.getName());
        return proFamilyRepository.save(proFamily);
    }

	@Override
	public ProFamily addProFamily(ProFamilyModel proFamilyModel) {
		ProFamily proFamily = model2entity(proFamilyModel);
		proFamily.setName(proFamilyModel.getName());
		return proFamilyRepository.save(proFamily);
	}

	@Override
	public ProFamily findById(int id) {
		return proFamilyRepository.findById(id);
	}

	@Override
	public List<ProFamily> getAll() {
		return proFamilyRepository.findAll();
	}

	@Override
	public List<ProFamily> getAllNotEmpty() {
		// TODO Auto-generated method stub
		return null;
	}

}
