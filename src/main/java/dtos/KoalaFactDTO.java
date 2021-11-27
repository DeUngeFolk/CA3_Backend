package dtos;

public class KoalaFactDTO {

    private String[] data;
    private String koalaFact;

    public KoalaFactDTO(KoalaFactDTO koalaFactDTO) {
        this.koalaFact = koalaFactDTO.getData()[0];
    }

    public KoalaFactDTO(String koalaFact) {
        this.koalaFact = koalaFact;
    }

    public String getFact() {
        return koalaFact;
    }

    public void setFact(String fact) {
        this.koalaFact = fact;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
