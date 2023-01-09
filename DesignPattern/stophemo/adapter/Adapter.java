package adapter;

public class Adapter implements Translator {
    private Speaker speaker;
    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String result = speaker.speak();
        // 手语翻译，理解 （相应转换逻辑）
        return result;
    }
}
