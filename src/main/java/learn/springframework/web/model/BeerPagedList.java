package learn.springframework.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPagedList extends PageImpl<BeerDto> {

  /* 
  ? PageImpl se especializa para poder trabajar con una lista
  ? paginada de objetos eneste caso de BeerDto
  */ 
  public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
    super(content, pageable, total);
    //TODO Auto-generated constructor stub
  }

  public BeerPagedList(List<BeerDto> content){
    super(content);
  }
  
}
