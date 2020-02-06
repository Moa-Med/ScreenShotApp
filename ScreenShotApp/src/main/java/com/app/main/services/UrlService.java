package com.app.main.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.main.model.Url;
import com.app.main.repository.UrlRepository;

import it.grabz.grabzit.GrabzItClient;

@Service
@Transactional
public class UrlService {
	
	private final UrlRepository urlRepository;
	
	public UrlService(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}
	
	public int index=0;
	
	
	public int urlSave(Url url)throws Exception {    
		//verify the url (1 if correct and -1 if not)
		int verify=1;
		
		String filePath;
		
		String urls[]=url.getUrls().split(";");
		
		//loop through urls to screen and save if good url
		for(int i=0;i<urls.length;i++) {
			
		if(urls[i].startsWith("https://")) {
			
			Url urlValue=new Url();
				
				//Replace "APPLICATION KEY", "APPLICATION SECRET" with the values from your account!
				GrabzItClient grabzIt = new GrabzItClient("YzRmZTA4NzIxMDllNDYzZWI3OGRjNWZiZmRlMWFlNmY=", "CAFMPz8NWz8/QmAgcj8/Pz9hEz8dHVQ/Pj85PzM/Pz8=");
					
				// To take a image screenshot
				grabzIt.URLToImage(urls[i]);
						
				//Creating a File object
			    File file = new File("/Snapshot");
			    //Creating the directory
			    if(file.mkdir()) {
			    index++;					
				filePath = "/Snapshot/img"+index+".png";
			    }else {
				index++;					
				filePath = "/Snapshot/img"+index+".png";	
			    }
				
				grabzIt.SaveTo(filePath);				
				
				urlValue.setUrls(urls[i]);
				urlValue.setFilename(filePath);
				urlRepository.save(urlValue);

		}else {verify=-1;}			
		
		}
		
		if(verify==-1 & urls.length>0) {verify=1;}
		
		return verify;
	}
	
public List<Url> getAllUrls(){
	List<Url> urls= new ArrayList<>();	
	for(Url url:urlRepository.findAll()) {
		urls.add(url);
	}
		return urls;
	}
	
	
	public void deleteUrl(long id){
		urlRepository.deleteById(id);
	}
}
