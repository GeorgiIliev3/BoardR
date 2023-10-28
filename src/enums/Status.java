package enums;

public enum Status {
    OPEN, TO_DO, IN_PROGRESS, DONE, VERIFIED;

    public String toString(Status status) {
        String statusToString = "";
        switch (String.valueOf(status)){
            case "OPEN":
                statusToString = "Open";
                break;
            case "TO_DO":
                statusToString = "To Do";
                break;
            case "IN_PROGRESS":
                statusToString = "In progress";
                break;
            case "DONE":
                statusToString = "Done";
                break;
            case "VERIFIED":
                statusToString = "Verified";
                break;
        }
        return statusToString;
    }
}
