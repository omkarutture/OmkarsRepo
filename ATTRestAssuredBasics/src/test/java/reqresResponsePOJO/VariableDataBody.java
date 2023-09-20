package reqresResponsePOJO;

import java.util.List;

public class VariableDataBody {

	Integer page;
	Integer per_page;
	Integer total;
	Integer total_pages;
	//Above are separate variables
	
	List<Data> data;
	//here, as this is a Array will use "List" and the list elements will be stored in resp. class. i.e., here "Data" will be class
	
	Support support;
	//this nested JSON will be stored in resp. class. i.e., here "Support" will be class

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}
}
