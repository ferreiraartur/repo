package com.algaworks.brewer.storage.local;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {
	
	
	public String salvarTemporariamente(MultipartFile[] files);

}
