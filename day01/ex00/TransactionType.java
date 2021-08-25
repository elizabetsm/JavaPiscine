public enum TransactionType {
        CREDIT("OUTCOME", ""), DEBIT("INCOME", "+");

        private String text;
        private String sign;

    TransactionType(String text, String sign) {
            this.text = text;
            this.sign = sign;
        }

        @Override
        public String toString() {
            return text;
        }

        public String getSign() {
            return sign;
        }

}
