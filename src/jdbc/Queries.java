package jdbc;

public interface Queries {
    String CREATE_NEW_USER = "INSERT INTO `practice`.`customers` (`name`, `email`, `mobile`, `created_date`, `last_updated_date`) " +
            "VALUES (?, ?, ?, NOW(), NOW());";

    String CREATE_NEW_RESTAURANT = "INSERT INTO `practice`.`restaurants` (`name`, `brand_name`, `business_name`, `area_code`, `location_name`, `address`, `operation_status`, `online_status`, `contact_number`, `created_date`, `last_updated_date`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

    String CREATE_NEW_DELIVERY_AGENT = "INSERT INTO `practice`.`delivery_agents` (`name`, `mobile`, `operation_status`, `created_date`, `last_updated_date`) " +
            "VALUES (?, ?, ?, NOW(), NOW());";

    String CREATE_NEW_MENU_ITEM = "INSERT INTO `practice`.`menu_items` (`restaurant_id`, `name`, `price`, `menu_visibility_flag`, `menu_availability_flag`, `description`, `image_url`, `created_date`, `last_updated_date`) " +
            "VALUES (?, ?, ?, ?, ?, ?, NULL, NOW(), NOW());";

    String CREATE_NEW_ORDER = "INSERT INTO `practice`.`order` (`customer_id`, `restaurant_id`, `delivery_agent_id`, `status`, `amount`, `discount`, `created_date`, `last_updated_date`) " +
            "VALUES (?, ?, NULL, 'PLACED', ?, ?, NOW(), NOW());";

    String CREATE_NEW_ORDER_ITEM = "INSERT INTO `practice`.`order_item` (`order_id`, `menu_item_id`, `price`, `discount`, `quantity`) " +
            "VALUES (?, ?, ?, ?, ?);";

    String FIND_MENU_ITEMS_IN = "SELECT * FROM practice.menu_items where practice.menu_items.menu_item_id in (?);";

    String FIND_LAST_CREATED_ORDER = "SELECT * FROM practice.order ORDER BY practice.order.order_id DESC LIMIT 1;";

    String FIND_AVAILABLE_DELIVERY_AGENT = "SELECT delivery_agent_id as id FROM practice.delivery_agents " +
            "where practice.delivery_agents.operation_status = 'AVAILABLE' LIMIT 1;";

    String UPDATE_DELIVERY_AGENT_OPS_STATUS = "UPDATE `practice`.`delivery_agents` SET `operation_status` = ? " +
            "WHERE (`delivery_agent_id` = ?);";

    String ASSIGN_DELIVERY_AGENT_TO_ORDER = "UPDATE `practice`.`order` SET `delivery_agent_id` = ? WHERE (`order_id` = ?);";

    String FIND_SECOND_HIGHEST_PRICED_MENU_ITEM_BY_TYPE = "WITH Analytics as (SELECT name, preference_type, price, DENSE_RANK() OVER (PARTITION BY preference_type Order By price DESC) AS ROW_NUM FROM practice.menu_items)\n" +
            "SELECT name, preference_type, price\n" +
            "FROM  Analytics\n" +
            "Where ROW_NUM = 2;";

    String FIND_MAX_AVG_BY_TYPE = "SELECT ROUND(AVG(price), 2) as avg_price, MAX(price) as max_price, preference_type \n" +
            "FROM practice.menu_items\n" +
            "Group by preference_type;";
}
